package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

	Users findUserByUsername(String username);
	List<Users> findAll();
}
