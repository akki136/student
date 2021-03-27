package com.crudApp.student.serviceI;

import com.crudApp.bo.Status;
import com.crudApp.bo.StudentBO;

public interface StudentServiceI {

	public Status  AddStudent(StudentBO bo);
	public Status  getStudent(Integer id);
	public Status  deleteStudent(Integer id);
	public Status updateStudent(StudentBO bo);
	
}
