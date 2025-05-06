package com.synchrony.synchronyapp.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

import com.synchrony.synchronyapp.model.ViewImgurResponse;
import com.synchrony.synchronyapp.model.DeleteImageResponse;
import com.synchrony.synchronyapp.model.UploadImageResponse;

@FeignClient(value="imgurClient",url="https://api.imgur.com/3/")
public interface ImgurFeignClient {
	
	
	 @GetMapping("/image/{imageHash}")
	    ViewImgurResponse getImage(
	        @RequestHeader("Authorization") String authorization,
	        @PathVariable("imageHash") String imageHash
	    );
	
	 
	 @PostMapping(value = "/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	    UploadImageResponse uploadImage(
	        @RequestHeader("Authorization") String authorization,
	        @RequestPart("image") MultipartFile image,
	        @RequestPart("type") String type,
	        @RequestPart("title") String title,
	        @RequestPart("description") String description
	    );
	 
	 @DeleteMapping("/image/{deleteHash}")
	    DeleteImageResponse deleteImage(
	        @RequestHeader("Authorization") String authorization,
	        @PathVariable("deleteHash") String deleteHash
	    );
}
