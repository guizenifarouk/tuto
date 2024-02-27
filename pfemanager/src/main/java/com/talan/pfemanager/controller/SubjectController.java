package com.talan.pfemanager.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.talan.pfemanager.dto.SubjectDTO;
import com.talan.pfemanager.entity.Subject;
import com.talan.pfemanager.repository.SubjectRepository;
import com.talan.pfemanager.service.SubjectService;

@RestController
public class SubjectController {

	@Autowired SubjectService subjectService;
	@Autowired SubjectRepository subjectRepo;
	@PostMapping("/subject/add")
	public void addSubject(@RequestBody SubjectDTO subjectDTO) {
		subjectService.save(subjectDTO);
	}

    @GetMapping("/subject/{id}")
    public SubjectDTO getSubject(@PathVariable int id) {
        return subjectService.findById(id);
    }
    @GetMapping("/subjects")
    public List<SubjectDTO> getSubjects(){
    	return subjectService.findAll();
    }
    
    @PostMapping("/search/{ids}")
    public List<Subject> search(@PathVariable List<Integer> ids){
    	return subjectService.findByTechnologies_IdIn(ids);
    }
    @DeleteMapping("/subject/delete/{id}")
    public String deleteById(@PathVariable int id) {
    	return subjectService.deleteSubjectById(id);
    }
    
    @DeleteMapping("/subject/delete/")
    public String deleteAll() {
    	return subjectService.deleteAll();
    	}
    
    @PutMapping("/update/{id}")
    public String updateSubject(@RequestBody SubjectDTO subjectDTO ,@PathVariable int id) {
    	return  subjectService.updateSubject(subjectDTO, id);
    }
}
