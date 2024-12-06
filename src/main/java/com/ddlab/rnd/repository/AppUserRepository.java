package com.ddlab.rnd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ddlab.rnd.entity.AppUser;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {

}
