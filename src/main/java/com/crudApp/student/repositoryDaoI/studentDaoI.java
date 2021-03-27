package com.crudApp.student.repositoryDaoI;

import com.crudApp.bo.Status;
import com.crudApp.bo.StudentBO;

public interface studentDaoI {

	public StudentBO  AddStudent(StudentBO bo);
	public StudentBO  getStudent(Integer id);
	public StudentBO  deleteStudent(Integer id);
	public StudentBO updateStudent(StudentBO bo);
	
}
