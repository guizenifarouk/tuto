package com.talan.pfemanager.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talan.pfemanager.dto.ApplicationDTO;
import com.talan.pfemanager.entity.Application;
import com.talan.pfemanager.helper.ApplicationHelper;
import com.talan.pfemanager.repository.ApplicationRepository;
import com.talan.pfemanager.service.ApplicationService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	ApplicationRepository applicationRepository;

	@Override
	public void addApplication(ApplicationDTO applicationDTO) {
		Application application = ApplicationHelper.dtoToEntity(applicationDTO);
		applicationRepository.save(application);
	}

	@Override
	public ApplicationDTO updateApplication(ApplicationDTO applicationDTO, int id) {
		Application application = null;
		Optional<Application> applicationOptional = applicationRepository.findById(id);
		if (applicationOptional.isPresent())
			application = applicationOptional.get();
		application.setCoverLetter(applicationDTO.getCoverLetter());
		application.setResume(applicationDTO.getResume());
		applicationRepository.save(application);
		return ApplicationHelper.entityToDto(application);

	}

	@Override
	public void deleteApplicationById(int id) {
		applicationRepository.deleteById(id);

	}

	@Override
	public void deleteAllApplication() {
		applicationRepository.deleteAll();

	}

	@Override
	public List<ApplicationDTO> getAllapplications() {
		List<ApplicationDTO> allApplicationsDTO = new ArrayList<ApplicationDTO>();
		applicationRepository.findAll()
				.forEach((application) -> allApplicationsDTO.add(ApplicationHelper.entityToDto(application)));
		return allApplicationsDTO;
	}

	@Override
	public List<ApplicationDTO> getAppliationsByUserId(int id) {
		List<ApplicationDTO> allApplicationsDTO = new ArrayList<ApplicationDTO>();
		applicationRepository.findApplicationByUserId(id).forEach((application) -> allApplicationsDTO.add(ApplicationHelper.entityToDto(application)));
		return allApplicationsDTO;
	}

}
