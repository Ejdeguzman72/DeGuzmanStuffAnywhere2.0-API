package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.models.MedicalTransaction;

@Repository
public interface MedicalTransactionRepository extends JpaRepository<MedicalTransaction,Long>{

}
