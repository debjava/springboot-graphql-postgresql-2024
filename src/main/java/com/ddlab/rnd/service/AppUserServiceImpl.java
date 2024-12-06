package com.ddlab.rnd.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddlab.rnd.entity.AppUser;
import com.ddlab.rnd.repository.AppUserRepository;

@Service
public class AppUserServiceImpl {
	
	@Autowired
	private AppUserRepository appUserRepo;

	public String createAppUser(AppUser appUser) {
		appUserRepo.save(appUser);
		return "App User information saved successfully ...";
	}
	
	public AppUser createNewAppUser(AppUser appUser) {
		appUserRepo.save(appUser);
		return appUser;
	}
	
	public Optional<AppUser> getAppUserById(long id) {
//		Long longId = Long.parseLong(id);
		return appUserRepo.findById(id);
	}
	
	public AppUser updateAppUser(long id, String nickName) {
		AppUser appUser = new AppUser();
		appUser.setId(id);
		appUser.setNickName(nickName);
		
		appUserRepo.save(appUser);
		return appUser;
	}
	
	public String deleteById(long id) {
		appUserRepo.deleteById(id);
		return "User information deleted successfully ...";
	}
	
	
}
