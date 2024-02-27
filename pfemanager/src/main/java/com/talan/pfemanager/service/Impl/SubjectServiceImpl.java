package com.talan.pfemanager.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.talan.pfemanager.dto.SubjectDTO;
import com.talan.pfemanager.entity.Subject;
import com.talan.pfemanager.helper.SubjectHelper;
import com.talan.pfemanager.repository.SubjectRepository;
import com.talan.pfemanager.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired SubjectRepository subjectRepository; 
	
	public String save(SubjectDTO subjectDto) {
		subjectRepository.save(SubjectHelper.subjectDtoToEntity(subjectDto));
		return "Subject added successfully";
	}

	@Override
	public List<SubjectDTO> findAll() {
		List<Subject> findAll = (List<Subject>) subjectRepository.findAll();
		return SubjectHelper.subjectEntityToDto(findAll);

	}

	@Override
	public SubjectDTO findById(int id) {
		return SubjectHelper.subjectEntityToDto(subjectRepository.findById(id).get());
	}

	@Override
	public String deleteSubjectById(int id) {
		 subjectRepository.deleteById(id);
		return "Subject deleted successfully";
	}

	@Override
	public String updateSubject(SubjectDTO subjectdto, int id) {
		SubjectDTO subjectDTO;
		subjectDTO = this.findById(id);
		System.out.println("out");
	        if (subjectDTO !=null) {
	        	System.out.println("in");
	        	subjectdto.setId(id);      
	             SubjectHelper.subjectEntityToDto(subjectRepository.save(SubjectHelper.subjectDtoToEntity(subjectdto)));
	             return "subject updated successfully";
	        }
	        return "could not find user id = " + id;
	}

	@Override
	public String deleteAll() {
		 subjectRepository.deleteAll();
		 return "all subjects deleted successfully";
	}

	@Override
	public List<Subject> findByTechnologies_IdIn(List<Integer> Ids) {
		return subjectRepository.findByTechnologies_IdIn(Ids);
	}

}
