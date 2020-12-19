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
	
	@Query(value = "select us.userid,us.email,us.name,us.password,us.username,r.descr, ust.statusdescr\r\n" + 
			"from users us, role r, user_status  ust \r\n" + 
			"where us.roleid = r.roleid\r\n" + 
			"and us.user_status = ust.user_status_id",  nativeQuery = true)
	List<Object> findAllUsersInformation();
}
