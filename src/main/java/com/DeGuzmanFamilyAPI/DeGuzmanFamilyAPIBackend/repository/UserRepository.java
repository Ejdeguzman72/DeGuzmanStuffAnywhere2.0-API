package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.models.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

}
