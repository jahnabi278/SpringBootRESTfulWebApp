package com.synchrony.synchronyapp.model;

import lombok.Data;

@Data
public class UploadImageResponse {
	private boolean success;
	private int status;
	private ImagePixelData data;
}
