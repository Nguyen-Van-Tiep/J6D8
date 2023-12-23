package com.j6d8.service.impl;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.j6d8.service.UploadService;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    ServletContext app;

    public File save(MultipartFile file, String folder) {
//		File dir = new File(app.getRealPath("/assets/" + folder));
        File dir = new File("C:\\Users\\tuetr\\OneDrive\\Máy tính\\POLY\\Java6\\Code\\J6D8\\src\\main\\resources\\static\\assets\\images\\");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String s = System.currentTimeMillis() + file.getOriginalFilename();
        String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));

        try {
            File savedFile = new File(dir, name);
            file.transferTo(savedFile);
            System.out.println(savedFile.getAbsolutePath());
            return savedFile;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
