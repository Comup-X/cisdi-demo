package cn.com.cisdi.demo.controller;

import cn.com.cisdi.demo._base.Result;
import cn.com.cisdi.demo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Comup
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    private final IndexService indexService;

    @Autowired
    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @PostMapping("/importData")
    public Result importData(MultipartFile file) throws IOException, IllegalAccessException {
        return Result.ok(indexService.importData(file));
    }

    @GetMapping("/getData")
    public Result getData(int pageNumber, int pageSize) {
        return Result.ok(indexService.getData(pageNumber, pageSize));
    }
}
