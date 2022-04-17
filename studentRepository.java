package com.springrest.springrest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springrest.springrest.model.student;

@Repository

public interface studentRepository extends CrudRepository<student, Long> {
	

}
