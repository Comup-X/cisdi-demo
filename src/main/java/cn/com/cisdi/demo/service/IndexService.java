package cn.com.cisdi.demo.service;

import cn.com.cisdi.demo._base.Page;
import org.bson.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Comup
 */
public interface IndexService {
    /**
     * 上传文件并导入数据
     *
     * @param file 上传的文件
     * @return 操作是否成功
     * @throws IllegalAccessException 创建文件目录异常
     * @throws IOException            读写文件异常
     */
    Boolean importData(MultipartFile file) throws IllegalAccessException, IOException;
    /**
     * 查询分页数据
     *
     * @param pageNumber 第几页 从0开始
     * @param pageSize   每页多少
     * @return 此页数据
     */
    Page<Document> getData(int pageNumber, int pageSize);
}
