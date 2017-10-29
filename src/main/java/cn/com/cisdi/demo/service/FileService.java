package cn.com.cisdi.demo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface FileService {

    /**
     * 列出所有上传的文件
     *
     * @return 所有上传的文件的文件名
     */
    List<String> listFile();

    /**
     * 下载文件
     *
     * @param fileName 文件名
     */
    void download(HttpServletRequest request, HttpServletResponse response, String fileName) throws IOException, InterruptedException;

    /**
     * 获取文件上传目录
     * @return 文件上传保存目录
     */
    String getUploadPath();
}
