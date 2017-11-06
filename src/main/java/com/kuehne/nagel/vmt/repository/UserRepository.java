package com.kuehne.nagel.vmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuehne.nagel.vmt.model.CUser;

public interface UserRepository extends JpaRepository<CUser, Long> {
	 
	CUser findByUsername(String username);
}