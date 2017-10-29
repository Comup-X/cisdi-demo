package cn.com.cisdi.demo.service.impl;

import cn.com.cisdi.demo.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Comup
 */
@Service
public class FileServiceImpl implements FileService {

    @Value("${upload-path}")
    private String uploadPath;

    @Override
    public List<String> listFile() {
        Path path = Paths.get(uploadPath);
        File[] files = path.toFile().listFiles();
        if (files != null) {
            List<String> result = new ArrayList<>(files.length);
            Arrays.asList(files).forEach(file -> result.add(file.getName()));
            return result;
        }
        return new ArrayList<>(0);
    }

    @Override
    public void download(HttpServletRequest request, HttpServletResponse response, String fileName) throws IOException, InterruptedException {
        InputStream inputStream;
        ServletOutputStream out;
        Path path = Paths.get(uploadPath, fileName);
        File file = path.toFile();
        int fSize = Integer.parseInt(String.valueOf(file.length()));
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/x-download");
        response.setHeader("Accept-Ranges", "bytes");
        response.setHeader("Content-Length", String.valueOf(fSize));
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        inputStream = new FileInputStream(file);
        long pos = 0;
        if (null != request.getHeader("Range")) {
            // 断点续传
            response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
            try {
                pos = Long.parseLong(request.getHeader("Range").replaceAll("bytes=", "").replaceAll("-", ""));
            } catch (NumberFormatException e) {
                pos = 0;
            }
        }
        out = response.getOutputStream();
        String contentRange = "bytes " + pos + "" + "-" + (fSize - 1) + "" + "/" + fSize + "";
        response.setHeader("Content-Range", contentRange);
        inputStream.skip(pos);
        byte[] buffer = new byte[1024 * 10];
        int length;
        while ((length = inputStream.read(buffer, 0, buffer.length)) != -1) {
            out.write(buffer, 0, length);
            Thread.sleep(100);
        }
        if (null != out) {
            out.flush();
        }
        if (null != out) {
            out.close();
        }
        inputStream.close();
    }

    @Override
    public String getUploadPath() {
        return uploadPath;
    }
}
