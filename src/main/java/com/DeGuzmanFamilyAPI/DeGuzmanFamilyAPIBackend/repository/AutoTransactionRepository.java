package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.models.AutoTransaction;


@Repository
public interface AutoTransactionRepository extends JpaRepository<AutoTransaction,Long> {

}
