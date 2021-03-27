package com.crudApp.student.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.crudApp.bo.Status;
import com.crudApp.bo.StudentBO;
import com.crudApp.student.repositoryDao.StudentDao;
import com.crudApp.student.serviceI.StudentServiceI;

@Service
public class StudentServiceImpl implements StudentServiceI  {


	@Autowired
	StudentDao studentDao;

	@Override
	public Status AddStudent(StudentBO bo) {
		StudentBO entity=null;
		Status status=new Status();
		HttpStatus httpStatus=null;
		if(bo.getId()!=null)
		{
			entity=studentDao.getStudent(bo.getId());
			httpStatus=HttpStatus.CONFLICT;
		}
		if(entity==null)
		{
			bo=studentDao.AddStudent(bo);
			httpStatus=HttpStatus.CREATED;
			
		}
		status.setBo(bo);
		status.setHttpStatus(httpStatus);
		return status;
	}

	@Override
	public Status getStudent(Integer id) {
	
		StudentBO bo= studentDao.getStudent(id);
		Status status = sendStatus(bo);
		return status;
	}

	@Override
	public Status deleteStudent(Integer id) {
		StudentBO bo= studentDao.deleteStudent(id);
		Status status = sendStatus(bo);
		return status;
	}

	private Status sendStatus(StudentBO bo) {
		Status status=new Status();
		HttpStatus httpStatus=HttpStatus.OK;
		if(bo==null)
		{
			httpStatus=HttpStatus.NOT_FOUND;
		}
		status.setBo(bo);
		status.setHttpStatus(httpStatus);
		return status;
	}

	@Override
	public Status updateStudent(StudentBO bo) {
		StudentBO student= studentDao.updateStudent(bo);
		Status status = sendStatus(student);
		return status;
	}

}
