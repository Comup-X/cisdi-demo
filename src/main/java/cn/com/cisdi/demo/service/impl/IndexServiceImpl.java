package cn.com.cisdi.demo.service.impl;

import cn.com.cisdi.demo._base.Page;
import cn.com.cisdi.demo.dao.BaseDao;
import cn.com.cisdi.demo.dao.DataDao;
import cn.com.cisdi.demo.service.IndexService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @author Comup
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Value("${upload-path}")
    private String uploadPath;

    private final DataDao dataDao = BaseDao.getDao(DataDao.class);

    @Override
    public Boolean importData(MultipartFile file) throws IllegalAccessException, IOException {
        File savedFile = saveFile(file);
        return importDataToDB(savedFile);
    }

    @Override
    public Page<Document> getData(int pageNumber, int pageSize) {
        return dataDao.findAll(pageNumber, pageSize);
    }

    private Boolean importDataToDB(File file) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        List<Document> toInsert = new LinkedList<>();
        lines.stream().skip(1).forEach(line -> {
            String[] split = line.split(",");
            Document document = new Document();
            document.put("A1", Double.valueOf(split[0]));
            document.put("A2", Double.valueOf(split[1]));
            document.put("A3", Double.valueOf(split[2]));
            document.put("A4", Double.valueOf(split[3]));
            document.put("A5", Double.valueOf(split[4]));
            document.put("A6", Double.valueOf(split[5]));
            document.put("A7", Double.valueOf(split[6]));
            document.put("A8", Double.valueOf(split[7]));
            document.put("A9", Double.valueOf(split[8]));
            document.put("A10", Double.valueOf(split[9]));
            document.put("A11", Double.valueOf(split[10]));
            document.put("A12", Double.valueOf(split[11]));
            document.put("Quality", (split[12]));
            toInsert.add(document);
        });
        dataDao.save(toInsert);
        return Boolean.TRUE;
    }

    private File saveFile(MultipartFile file) throws IllegalAccessException, IOException {
        if (!file.isEmpty()) {
            File path = Paths.get(uploadPath).toFile();
            boolean mkSuccess = path.exists() || path.mkdirs();
            if (!mkSuccess) {
                throw new IllegalAccessException("Create file directory error");
            }

            String[] split = file.getOriginalFilename().split("\\.");

            String fileName = UUID.randomUUID().toString() + "." + split[split.length - 1 < 0 ? 0 : split.length - 1];

            File willSaveFile = Paths.get(uploadPath, fileName).toFile();
            mkSuccess = willSaveFile.exists() || willSaveFile.createNewFile();
            if (!mkSuccess) {
                throw new IllegalAccessException("Create file error");
            }

            OutputStream outputStream = new FileOutputStream(willSaveFile);
            BufferedOutputStream out = new BufferedOutputStream(outputStream);
            out.write(file.getBytes());
            out.flush();
            out.close();
            outputStream.close();
            return willSaveFile;
        } else {
            throw new IllegalArgumentException("Illegal file");
        }
    }
}
