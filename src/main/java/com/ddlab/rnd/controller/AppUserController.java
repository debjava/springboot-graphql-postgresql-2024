package com.ddlab.rnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddlab.rnd.dto.AppUserDto;
import com.ddlab.rnd.entity.AppUser;
import com.ddlab.rnd.service.AppUserServiceImpl;

@RestController
public class AppUserController {
	
	@Autowired
	private AppUserServiceImpl serviceImpl;
	
	@QueryMapping
    public AppUser getAppUserById(@Argument long id) {
        return serviceImpl.getAppUserById(id).get();
    }
	
	@MutationMapping
	public AppUser updateUser(@Argument long id, @Argument String nickName) {
		return serviceImpl.updateAppUser(id, nickName);
	}
	
	@MutationMapping
	public String removeUser(@Argument long id) {
		System.out.println("Trying to delete the user ...");
		return serviceImpl.deleteById(id);
	}
	
	@MutationMapping
	public AppUser createNewAppUser(@Argument(name = "appUserDto") AppUserDto appUserDto) {
		System.out.println("appUserDto: "+appUserDto);
		AppUser user = new AppUser();
		user.setFirstName(appUserDto.getFirstName());
		user.setLastName(appUserDto.getLastName());
		user.setNickName(appUserDto.getNickName());
		user.setShortDesc(appUserDto.getShortDesc());
		return serviceImpl.createNewAppUser(user);
	}
	
	@MutationMapping
	public String createAppUser(@Argument String firstName, @Argument String lastName, @Argument String nickName, @Argument String shortDesc) {
		AppUser appUser = new AppUser();
		appUser.setFirstName(firstName);
		appUser.setLastName(lastName);
		appUser.setNickName(nickName);
		appUser.setShortDesc(shortDesc);
		return serviceImpl.createAppUser(appUser);
	}

}
