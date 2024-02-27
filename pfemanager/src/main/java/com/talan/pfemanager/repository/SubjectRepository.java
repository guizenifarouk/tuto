package com.talan.pfemanager.repository;
import com.talan.pfemanager.dto.SubjectDTO;
import com.talan.pfemanager.entity.Subject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>{

	List<Subject> findByTechnologies_IdIn(List<Integer> Ids);
}
