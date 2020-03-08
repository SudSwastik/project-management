package com.sudarshan.sud.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sudarshan.sud.entities.Project;

public interface IProjectRepository extends CrudRepository<Project, Long>{

	@Override
    List<Project> findAll();
}
