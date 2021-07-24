package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.RunTracker;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Users;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.RunTrackerRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.UserRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service_interface.RunTrackerServiceInterface;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;

@Service
public class RunTrackerService implements RunTrackerServiceInterface {

	@Autowired
	private RunTrackerRepository runTrackerRepository;
	
	@Autowired
	private UserRepository usersRepository;
	
	public List<RunTracker> findAllRunTrackerInformation() {
		return runTrackerRepository.findAll();
	}
	
	public ResponseEntity<RunTracker> findRunTrackerInformationById(@PathVariable long runid) throws ResourceNotFoundException {
		RunTracker runTracker = runTrackerRepository.findById(runid)
				.orElseThrow(() -> new ResourceNotFoundException("Not Found"));
		return ResponseEntity.ok().body(runTracker);
	}
	
	public RunTracker addRunTrackerInformation(@Valid @RequestBody RunTracker runTracker) throws ResourceNotFoundException {
		String runDate = runTracker.getRunDate();
		double runDistance = runTracker.getRunDistance();
		String runTime = runTracker.getRunTime();
		Users user = usersRepository.findById(runTracker.getUser().getUserid())
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find"));
		RunTracker newRunTracker = new RunTracker(runDate,runDistance,runTime,user);
		return runTrackerRepository.save(newRunTracker);
	}
	
	public ResponseEntity<RunTracker> updateRunTrackerInformation(@PathVariable long runid,
			@Valid @RequestBody RunTracker runTrackerDetails) {
		RunTracker runTracker = null;
		try {
			runTrackerDetails = runTrackerRepository.findById(runid)
					.orElseThrow(() -> new ResourceNotFoundException("Not Found"));
			runTracker.setRunDate(runTrackerDetails.getRunDate());
			runTracker.setRunDistance(runTrackerDetails.getRunDistance());
			runTracker.setRunTime(runTracker.getRunTime());
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		final RunTracker updatedRunTrackerDetails = runTrackerRepository.save(runTracker);
		return ResponseEntity.ok().body(updatedRunTrackerDetails);
	}
	
	public Map<String,Boolean> deleteRunTrackerInformation(@PathVariable long runid) {
		runTrackerRepository.deleteById(runid);
		Map<String,Boolean> response =  new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@Override
	public long findCountOfRunTrackerInformation() {
		return runTrackerRepository.count();
	}
}
