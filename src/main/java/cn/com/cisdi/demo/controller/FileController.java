package cn.com.cisdi.demo.controller;

import cn.com.cisdi.demo._base.CSVUtil;
import cn.com.cisdi.demo._base.Result;
import cn.com.cisdi.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * 所有异常已在GlobalExceptionHandler中处理，无特殊要求可直接抛出异常
 *
 * @author Comup
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PutMapping("/setCSVField/{fileName}/{row}/{col}/{value}")
    public Result setCSVField(@PathVariable String fileName, @PathVariable int row, @PathVariable int col, @PathVariable String value) throws IOException {
        CSVUtil.setCSVField(Paths.get(fileService.getUploadPath(),fileName).toString(), value, row, col);
        return Result.ok(Boolean.TRUE);
    }

    @PutMapping("/delCSVColumn/{fileName}/{col}")
    public Result delCSVColumn(@PathVariable String fileName, @PathVariable int col) throws IOException {
        CSVUtil.delCSVColumn(Paths.get(fileService.getUploadPath(),fileName).toString(), col);
        return Result.ok(Boolean.TRUE);
    }

    @PutMapping("/delCSVRow/{fileName}/{row}")
    public Result delCSVRow(@PathVariable String fileName, @PathVariable int row) throws IOException {
        CSVUtil.delCSVRow(Paths.get(fileService.getUploadPath(),fileName).toString(), row);
        return Result.ok(Boolean.TRUE);
    }

    @GetMapping("")
    public Result listFile() {
        return Result.ok(fileService.listFile());
    }

    @GetMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response, String fileName) throws IOException, InterruptedException {
        fileService.download(request, response, fileName);
    }
}
