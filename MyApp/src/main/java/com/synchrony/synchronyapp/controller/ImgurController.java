package com.synchrony.synchronyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.synchrony.synchronyapp.model.UploadImageResponse;
import com.synchrony.synchronyapp.service.ImgurService;

@RestController
@RequestMapping("/api/imgur")
public class ImgurController {
	@Autowired
	ImgurService imgurService;


    @PostMapping("/upload")
    public ResponseEntity<UploadImageResponse> uploadImage(
        @RequestPart("image") MultipartFile image,
        @RequestParam("title") String title,
        @RequestParam("description") String description
    ) {
    	UploadImageResponse response = imgurService.uploadImage(image, title, description);
        return ResponseEntity.ok(response);
    }
}
