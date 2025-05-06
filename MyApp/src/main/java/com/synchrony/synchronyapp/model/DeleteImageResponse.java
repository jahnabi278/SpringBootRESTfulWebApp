package com.synchrony.synchronyapp.model;

import lombok.Data;

@Data
public class DeleteImageResponse {
	private boolean success;
    private int status;
    private Object data; 
}
