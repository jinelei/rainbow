package cn.jinelei.web.controller;

import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zhenlei
 */
@RestController
@RequestMapping("/file")
@ResponseBody
public class FileController {

    @RequestMapping("/upload")
    public String upload(@RequestParam("file1") MultipartFile file) {
        System.out.println(file.getName());
        return "upload";
    }

}
