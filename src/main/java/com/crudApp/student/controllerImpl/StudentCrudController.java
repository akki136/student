package com.crudApp.student.controllerImpl;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.crudApp.bo.Status;
import com.crudApp.bo.StudentBO;
import com.crudApp.bo.exceptions.StudentException;
import com.crudApp.student.serviceImpl.StudentServiceImpl;

@RestController
public class StudentCrudController implements com.crudApp.student.controller.Controller{


	@Autowired
	StudentServiceImpl studentService;

	@RequestMapping(method = RequestMethod.POST,value = "/AddStudent")
	@Override
	public ResponseEntity<StudentBO> AddStudent(@RequestBody StudentBO bo) {
		Status status=studentService.AddStudent(bo);
		try
		{
		return new ResponseEntity(status.getBo(),status.getHttpStatus());
		}catch(StudentException e)
		{
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
		catch(Exception e)
		{
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
	}

	@RequestMapping(method = RequestMethod.GET,value = "/getStudent/{id}")
	@Override
	public ResponseEntity<StudentBO> getStudent(@PathVariable(name = "id") Integer id) {
		// TODO Auto-generated method stub
		try
		{
		Status status=studentService.getStudent(id);
		return new ResponseEntity(status.getBo(),status.getHttpStatus());
		}catch(StudentException e)
		{
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
		catch(Exception e)
		{
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
	}



	@RequestMapping(method = RequestMethod.DELETE,value = "/getStudent/{id}")
	@Override
	public ResponseEntity<StudentBO> deleteStudent(@PathVariable(name = "id") Integer id) {
		try
		{
		Status status=studentService.deleteStudent(id);
		return new ResponseEntity(status.getBo(),status.getHttpStatus());
		}catch(StudentException e)
		{
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
		catch(Exception e)
		{
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
	}


	@RequestMapping(method = RequestMethod.PUT,value = "/getStudent/{id}")
	@Override
	public ResponseEntity<StudentBO> updateStudent(StudentBO bo) {
		try
		{
		Status status=studentService.updateStudent(bo);
		return new ResponseEntity(status.getBo(),status.getHttpStatus());
		}catch(StudentException e)
		{
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
		catch(Exception e)
		{
			
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
	}





}
