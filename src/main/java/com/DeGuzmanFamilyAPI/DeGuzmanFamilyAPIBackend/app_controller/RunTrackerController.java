package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.RunTracker;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service.RunTrackerService;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;
import com.fasterxml.jackson.databind.type.MapType;

@RestController
@RequestMapping("/app/run-tracker-app")
@CrossOrigin
public class RunTrackerController {

	@Autowired
	private RunTrackerService runTrackerService;
	
	@GetMapping("/all")
	public List<RunTracker> getAllRunTrackerInfoController() {
		return runTrackerService.findAllRunTrackerInformation();
	}
	
	@GetMapping("/run/{runid}")
	public ResponseEntity<RunTracker> getRunTrackerByIdController(@PathVariable long runid) throws ResourceNotFoundException {
		return runTrackerService.findRunTrackerInformationById(runid);
	}
	
//  @RequestMapping(value="/{accountId}", method = RequestMethod.POST, consumes={"text/plain", "application/*"})
//	@RequestMapping(value="/add-run-tracker-info", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/add-run-tracker-info")
	public RunTracker addRunTrackerInfoController(@RequestBody RunTracker runTracker) {
		return runTrackerService.addRunTrackerInformation(runTracker);
	}
	
	@PutMapping("/run/{runid}")
	public ResponseEntity<RunTracker> updatedRunTrackerInfoController(@PathVariable long runid,
			@Valid @RequestBody RunTracker runTrackerDetails) {
		return runTrackerService.updateRunTrackerInformation(runid, runTrackerDetails);
	}
	
	@DeleteMapping("/run/{runid}")
	public Map<String,Boolean> deleteRunTrackerInfoController(@PathVariable long runid) {
		return runTrackerService.deleteRunTrackerInformation(runid);
	}
	
	@CrossOrigin
	@GetMapping("/run-count")
	public long getCountOfRunTrackerInformation() {
		return runTrackerService.findCountOfRunTrackerInformation();
	}
}
