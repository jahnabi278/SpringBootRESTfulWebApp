package com.synchrony.synchronyapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.synchrony.synchronyapp.model.ViewImgurResponse;
import com.synchrony.synchronyapp.model.DeleteImageResponse;
import com.synchrony.synchronyapp.model.UploadImageResponse;
import com.synchrony.synchronyapp.openfeign.ImgurFeignClient;

@Service
public class ImgurService {

	@org.springframework.beans.factory.annotation.Value("${imgur.client-id}")
	private String clientId;

	@Autowired
	ImgurFeignClient imgurFeignClient;

	public ViewImgurResponse fetchImage(String imageHash) {
		String authHeader = "Client-ID " + clientId;
		return imgurFeignClient.getImage(authHeader, imageHash);
	}
	
	
	public UploadImageResponse uploadImage(MultipartFile file, String title, String description) {
        String authHeader = "Client-ID " + clientId;
        return imgurFeignClient.uploadImage(
            authHeader,
            file,
            "image",
            title,
            description
        );
    }
	
	public DeleteImageResponse deleteImage(String deleteHash) {
        String authHeader = "Client-ID " + clientId;
        return imgurFeignClient.deleteImage(authHeader, deleteHash);
    }

}
