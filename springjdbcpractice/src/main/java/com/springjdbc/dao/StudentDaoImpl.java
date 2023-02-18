package com.springjdbc.dao;

import com.springjdbc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDaoImpl implements StudentDao  {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public StudentDaoImpl() {
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Student student) {
        String query = "insert into student(id,name,city) values(?,?,?)";
        int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return r;

    }

    @Override
    public int change(Student student) {
        String query = "update student set name = ?, city = ? where id = ?";
        int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
        return r;
    }

    @Override
    public int delete(int sid) {
        String query = "delete from student where id = ?";
        int r = this.jdbcTemplate.update(query,sid);
        return r;
    }

    @Override
    public Student getStudent(int sid) {
        String query = "select * from student where id = ?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(query, rowMapper, sid);
        return  student;
    }

    @Override
    public List<Student> getAllStudent() {
        String query = "select * from student";
        List<Student> list = this.jdbcTemplate.query(query,new RowMapperImpl());
        return list;
    }

    @Override
    public List<Student> getAllStudentByName(String name) {
        String query = "select * from student where lower(name) = ?";
        List<Student> list = this.jdbcTemplate.query(query,new RowMapperImpl(), name);
        return list;

    }
}
