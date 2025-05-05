package com.synchrony.synchronyapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
public class SynchronyUser {
	@Id
	private String userName;
	private String passWord;
	private String name;
	private String city;
	private String mobile;

}
