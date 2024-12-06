package com.ddlab.rnd.dto;

import lombok.Data;
import lombok.ToString;

@Data @ToString
public class AppUserDto {

	private String firstName;
	private String lastName;
	private String nickName;
	private String shortDesc;
}
