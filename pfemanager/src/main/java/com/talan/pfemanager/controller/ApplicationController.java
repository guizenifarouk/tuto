package com.talan.pfemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.talan.pfemanager.dto.ApplicationDTO;
import com.talan.pfemanager.service.ApplicationService;

@RestController
public class ApplicationController {
	@Autowired
	ApplicationService applicationService;

	@PostMapping("/application/add")
	public void createApplication(@RequestBody ApplicationDTO applicationDTO) {
		applicationService.addApplication(applicationDTO);

	}

	@PutMapping("/application/update/{id}")
	public ApplicationDTO updateUser(@RequestBody ApplicationDTO applicationDTO, @PathVariable int id) {
	return applicationService.updateApplication(applicationDTO, id);

	}

	@DeleteMapping("/application/delete/{id}")
	public void deleteApplicationById(@PathVariable int id) {
     applicationService.deleteApplicationById(id);
	}
	@GetMapping("/applications")
    @ResponseBody
    public List<ApplicationDTO> getAllApplications() {
        return applicationService.getAllapplications();
    }
	
	@DeleteMapping("/Deleteapplications")
	public void deleteAllApplications(){
     applicationService.deleteAllApplication();
	}
	@GetMapping("/applications/user/{id}")
    @ResponseBody
    public List<ApplicationDTO> getApplicationsByUserId(@PathVariable int id) {
        return applicationService.getAppliationsByUserId(id);
    }

}
