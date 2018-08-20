package org.tom.web.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tom.dto.FileInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * 文件控制器
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/5/27 下午6:08
 */
@RestController
@RequestMapping("/files")
public class FileController {

    private String folder = "upload";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {

        System.out.println("multipartFile[name:" + file.getName() + ", originalFilename:" + file.getOriginalFilename() + ", size:" + file.getSize() + "]");

        File fileDir = new File(folder);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        System.out.println("fileDir: " + fileDir.getAbsolutePath());
        String fileId = new Date().getTime() + "";
        File localFile = new File(folder, fileId + ".txt").getAbsoluteFile();
        file.transferTo(localFile);

        return new FileInfo(fileId, localFile.getPath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws Exception {

        File fileDir = new File(folder);
        System.out.println("fileDir: " + fileDir.getAbsolutePath());
        try (InputStream inputStream = new FileInputStream(new File(folder, id + ".txt").getAbsoluteFile());
             OutputStream outputStream = response.getOutputStream();) {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=test.txt");
            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        }
    }

}
