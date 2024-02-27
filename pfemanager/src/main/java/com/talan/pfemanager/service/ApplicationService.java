package com.talan.pfemanager.service;

import java.util.List;

import com.talan.pfemanager.dto.ApplicationDTO;

public interface ApplicationService {

	void addApplication(ApplicationDTO applicationDTO);

	ApplicationDTO updateApplication(ApplicationDTO applicationDTO, int id);

	void deleteApplicationById(int id);

	void deleteAllApplication();

	List<ApplicationDTO> getAllapplications();

	List<ApplicationDTO> getAppliationsByUserId(int id);

}
