package com.crudApp.student.repository;

import org.springframework.data.repository.CrudRepository;

import com.crudApp.student.entity.StudentEntity;

public interface StudentRepositroy extends CrudRepository<StudentEntity,Integer> {

}
