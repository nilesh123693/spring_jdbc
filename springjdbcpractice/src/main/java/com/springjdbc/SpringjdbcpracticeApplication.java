package com.springjdbc;

import com.springjdbc.dao.Config;
import com.springjdbc.dao.StudentDao;
import com.springjdbc.dao.StudentDaoImpl;
import com.springjdbc.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringjdbcpracticeApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringjdbcpracticeApplication.class, args);

		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		StudentDao studentDao =  context.getBean(StudentDao.class);
        //insert student
//		Student student = new Student(6,"tarun","surpala");
//		int r = studentDao.insert(student);
//		System.out.println("number of rows affected :" + r);

//      update student
//		student = new Student(2,"raju","barwah");
//		int r = studentDao.change(student);
//		System.out.println("number of rows changes : " + r);


        // delete student
//		int r = studentDao.delete(6);
//		System.out.println(r + " rows deleted");
//        Student student = studentDao.getStudent(1);
//		System.out.println(student);

//     get All student
//		List<Student> students = studentDao.getAllStudent();
//		for(Student st : students) {
//			System.out.println(st);
//		}

		//get All student by name
		List<Student> students = studentDao.getAllStudentByName("tarun");
		for(Student st: students) {
			System.out.println(st);
		}

	}

}
