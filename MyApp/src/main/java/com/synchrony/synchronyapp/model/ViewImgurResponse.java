package com.synchrony.synchronyapp.model;

import lombok.Data;

@Data
public class ViewImgurResponse {
	private boolean success;
    private int status;
    private ImageData data;

}
