package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_dto.UserInfoDTO;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long>{

	Users findUserByUsername(String username);
	List<Users> findAll();
	
	@Query(value = "SELECT * FROM USERS WHERE USER_STATUS = 1", nativeQuery=true)
	List<Users> findAllPendingUsers();
	
	@Query(value="SELECT US.USER_ID,US.NAME,US.USERNAME,US.PASSWORD,US.EMAIL,UST.USER_STATUS_ID,US.ROLE_ID,UST.USER_STATUS_DESCR FROM USERS US, USER_STATUS UST WHERE US.USER_STATUS_ID = UST.USER_STATUS_ID", nativeQuery = true)
	List<Users> findAllUsersInformation();
}
