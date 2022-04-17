package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springrest.springrest.beans.studentwrapper;
import com.springrest.springrest.exception.recordnotfoundException;
import com.springrest.springrest.service.studentservice;

@Controller
public class studentcontroller {
	@Autowired
	private studentservice studentService;
	@PostMapping("/saveStudent")
	public ResponseEntity<studentwrapper> saveStudent(@RequestBody studentwrapper studentWrapper){
		studentWrapper = studentService.saveStudent(studentWrapper);
		return ResponseEntity.ok(studentWrapper);
		
	}
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<studentwrapper> getStudentById(@PathVariable Long id) throws recordnotfoundException
	{
		studentwrapper studentWrapper= studentService.getStudentById(id);
		return ResponseEntity.ok(studentWrapper);
	}
@PutMapping("/updateStudent")

	public ResponseEntity<studentwrapper> updateStudent(@RequestBody studentwrapper studentWrapper)throws recordnotfoundException
{
		studentWrapper = studentService.updateStudentDetails(studentWrapper);
		
		
		return ResponseEntity.ok(studentWrapper);

}
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<studentwrapper> deleteStudentById(@PathVariable Long id) throws recordnotfoundException
	{
		 studentService.deleteById(id);
		 return ResponseEntity.noContent().build();
	
	}
}