package com.talan.pfemanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talan.pfemanager.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
	List<Application> findApplicationByUserId(int id);

}
