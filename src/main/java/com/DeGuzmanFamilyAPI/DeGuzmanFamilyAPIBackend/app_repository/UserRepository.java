package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

	Users findUserByUsername(String username);
	List<Users> findAll();
	
	@Query(value = "SELECT * FROM USERS WHERE USER_STATUS = 1", nativeQuery=true)
	List<Users> findAllPendingUsers();
	
	@Query(value = "select us.user_id,us.name,us.username,us.password,us.email,r.role_id,r.role_descr,us2.user_status_id,us2.user_status_descr " +
			"from users us, user_status us2, roles r " + 
			"where us.user_status_id = us2.user_status_id  " + 
			"and us.role_id = r.role_id",  nativeQuery = true)
	List<Users> findAllUsersInformation();
}
