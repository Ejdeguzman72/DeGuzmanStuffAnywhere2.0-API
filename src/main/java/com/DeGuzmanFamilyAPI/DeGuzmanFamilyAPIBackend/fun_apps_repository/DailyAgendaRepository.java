package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.fun_apps_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.fun_apps_models.DailyAgenda;

@Repository
public interface DailyAgendaRepository extends JpaRepository<DailyAgenda,Integer> {

}
