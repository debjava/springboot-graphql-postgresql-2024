package com.ddlab.rnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ddlab.rnd.entity.AppUser;
import com.ddlab.rnd.service.AppUserServiceImpl;

@Component
public class AutoRun {
	
	@Autowired
	private AppUserServiceImpl serviceImpl;
	
	private String saveUser() {
		AppUser user = new AppUser();
		user.setFirstName("John");
		user.setLastName("Abraham");
		user.setNickName("johny");
		user.setShortDesc("A very good actor in Bollywood");
		
		String response = serviceImpl.createAppUser(user);
		return response;
	}
	
//	private void showUserById() {
//		AppUser user = serviceImpl.getAppUserById("2").get();
//		System.out.println("App User: "+user);
//	}

	@EventListener(ApplicationReadyEvent.class)
	private void run() {
		System.out.println("App started running ...");
//		showUserById();
//		String response = saveUser();
//		System.out.println("Response while saving user: "+response);
	}
}
