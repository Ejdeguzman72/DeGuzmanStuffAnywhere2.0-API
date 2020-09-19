package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.fun_apps_services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.fun_apps_models.DailyAgenda;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.fun_apps_repository.DailyAgendaRepository;

@Service
public class DailyAgendaService {

	@Autowired
	private DailyAgendaRepository dailyAgendaRepository;
	
	public List<DailyAgenda> findAllDailyAgendaItems() {
		List<DailyAgenda> dailyAgendaList = new ArrayList<>();
		return dailyAgendaRepository.findAll();
	}
	
	public List<String> findDailyAgendaItemName() {
		return dailyAgendaRepository.getAllDailyAgendaItemNames();
	}
	
	public ResponseEntity<DailyAgenda> findDailyAgendabyId(@PathVariable int agendaId) throws ResourceNotFoundException {
		DailyAgenda agendaItem = dailyAgendaRepository.findById(agendaId)
				.orElseThrow(() -> new ResourceNotFoundException("Cannot Find Item"));
		return ResponseEntity.ok().body(agendaItem);
	}
	
	public DailyAgenda saveDailyAgendaItem(@Valid @RequestBody DailyAgenda item) {
		return dailyAgendaRepository.save(item);
	}
	
	public ResponseEntity<DailyAgenda> updateDailyAgenda(@PathVariable int agendaId, @Valid @RequestBody DailyAgenda itemDetails) throws ResourceNotFoundException {
		DailyAgenda dailyAgenda = dailyAgendaRepository.findById(agendaId)
				.orElseThrow(() -> new ResourceNotFoundException("Agenda Item not Found"));
		try {
			dailyAgenda.setName(itemDetails.getName());
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		final DailyAgenda updatedAgendaItem = dailyAgendaRepository.save(dailyAgenda);
		return ResponseEntity.ok().body(updatedAgendaItem);
	}
	
	public Map<String,Boolean> deleteAgendaItem(@PathVariable int agendaId) {
		dailyAgendaRepository.deleteById(agendaId);
		
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;
	}
}
