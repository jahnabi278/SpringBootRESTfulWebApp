package com.terra.myapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Users {
	@Id
	private int id;
	private String userName;
	private String passWord;
	private String name;
	private String city;
	private String mobile;
}
