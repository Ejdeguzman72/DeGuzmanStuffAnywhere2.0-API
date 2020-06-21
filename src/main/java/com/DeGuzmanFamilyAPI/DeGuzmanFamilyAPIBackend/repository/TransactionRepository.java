package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

}