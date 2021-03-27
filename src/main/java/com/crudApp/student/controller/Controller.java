package com.crudApp.student.controller;

import org.springframework.http.ResponseEntity;

import com.crudApp.bo.StudentBO;

public interface Controller {
public ResponseEntity<StudentBO>  AddStudent(StudentBO bo);
public ResponseEntity<StudentBO>  getStudent(Integer id);
public ResponseEntity<StudentBO>  deleteStudent(Integer id);
public ResponseEntity<StudentBO> updateStudent(StudentBO bo);
}
