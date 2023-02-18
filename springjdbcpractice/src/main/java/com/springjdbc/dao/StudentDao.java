package com.springjdbc.dao;

import com.springjdbc.entity.Student;

import java.util.List;

public interface StudentDao {
    public int insert(Student student);
    public int change(Student student);

    public int delete(int sid);

    public Student getStudent(int sid);

    public List<Student> getAllStudent();

    public List<Student> getAllStudentByName(String name);
}
