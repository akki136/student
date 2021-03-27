package com.crudApp.student.repositoryDao;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crudApp.bo.StudentBO;
import com.crudApp.bo.exceptions.StudentException;
import com.crudApp.student.entity.StudentEntity;
import com.crudApp.student.repository.StudentRepositroy;
import com.crudApp.student.repositoryDaoI.studentDaoI;

@Component
public class StudentDao implements studentDaoI{

	
	@Autowired
	StudentRepositroy repositroy;

	@Override
	public StudentBO AddStudent(StudentBO bo) {
		try
		{
		StudentEntity studentEntity=new StudentEntity();
		BeanUtils.copyProperties(bo, studentEntity);
		
		repositroy.save(studentEntity);
		
		bo.setId(studentEntity.getId());
		}
		catch(Exception e )
		{
			
			throw new StudentException("Failed to Insert Student "+e.getMessage());
		}
		return bo;
	}

	@Override
	public StudentBO getStudent(Integer id) {
		try
		{
		Optional<StudentEntity> studentEntity= repositroy.findById(id);
		 StudentBO bo=new StudentBO();
		 if(!studentEntity.isPresent())
		 {
			return null;
			
		 }
		 BeanUtils.copyProperties(bo, studentEntity);
		 return bo;
		}
		catch(Exception e )
		{
			
			throw new StudentException("Failed to get Student"+e.getMessage());
		}
	}

	@Override
	public StudentBO deleteStudent(Integer id) {
		try
		{
		StudentBO bo= this.getStudent(id);
		if(bo==null)
		{
			return null;
		}
		repositroy.deleteById(id);
		return bo;
		}
		catch(Exception e )
		{
			
			throw new StudentException("Failed to Delete Student "+e.getMessage());
		}
	}

	@Override
	public StudentBO updateStudent(StudentBO bo) {
		try
		{
		StudentBO student= this.getStudent(bo.getId());
		if(student==null)
		{
			return null;
		}
		StudentEntity studentEntity=new StudentEntity();
		BeanUtils.copyProperties(bo, studentEntity);
		this.repositroy.save(studentEntity);
		return bo;
		}
		catch(Exception e )
		{
			
			throw new StudentException("Failed to update Student "+e.getMessage());
		}
	}
	
	
	
}
