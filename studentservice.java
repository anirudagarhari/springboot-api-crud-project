package com.springrest.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.beans.studentwrapper;
import com.springrest.springrest.exception.recordnotfoundException;
import com.springrest.springrest.model.student;
import com.springrest.springrest.repository.studentRepository;
import java.util.*;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service

public class studentservice {
	@Autowired
	private studentRepository repository;
	
	public studentwrapper saveStudent(studentwrapper inputstudent) {
		student student=new student();
		//student.setId(inputstudent.getId());
		student.setName(inputstudent.getName());
		
		student= repository.save(student);
		inputstudent.setId(student.getId());
		inputstudent.setName(student.getName());
		return inputstudent;
		}

	
	public studentwrapper getStudentById(Long id) throws recordnotfoundException {
		studentwrapper studentWrapperOutput= null;
		java.util.Optional<student> studentOptionalData = repository.findById(id);
		
		if(studentOptionalData.isPresent()) {
			
			studentWrapperOutput=new studentwrapper();
			student Student=studentOptionalData.get();
			 studentWrapperOutput.setId(Student.getId());
			 studentWrapperOutput.setName(Student.getName());
			 
			
		}
		else
		{
		throw new recordnotfoundException("student record not found ");
		}
		return studentWrapperOutput;
	}
	
	
	public studentwrapper updateStudentDetails(studentwrapper inputstudent) throws recordnotfoundException {
		
		java.util.Optional<student> studentOptionalData = repository.findById(inputstudent.getId());
		
		if(studentOptionalData.isPresent()) {
			
			student Student=studentOptionalData.get();
			
			Student.setName(inputstudent.getName());
			repository.save(Student);
			studentwrapper studentwrapper=new studentwrapper();
			 studentwrapper.setId(Student.getId());
			 studentwrapper.setName(Student.getName());
			 
			 return studentwrapper;
		}
		else
		{
		throw new recordnotfoundException("student record not found ");
		}
		
	}
	public void deleteById(Long id) throws recordnotfoundException{
		java.util.Optional<student> studentOptionalData = repository.findById(id);
		if(studentOptionalData.isPresent()) {
			student Student=studentOptionalData.get();
			repository.delete(Student);
		}else
		{
			throw new  recordnotfoundException("student record not found ");
		}
		
		
		
	}
	
		
		
}		
		


