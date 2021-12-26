package com.example.relational.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.relational.entity.Parent;
import com.example.relational.entity.Student;
import com.example.relational.repository.StudentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentRepositoryTest {

	@Autowired
	StudentRepository studentRepository;

//	@Test
//	public void addStudent() {
//		Parent parent = Parent.builder().fatherName("Bharath1").motherName("Gayu1").build();
//		Student student = Student.builder().name("JaiKuamr1").parent(parent).build();
//
//		int id = studentRepository.save(student).getId();
//		System.out.println("Student ID = " + id);
//
//		Student savedStudent = studentRepository.getById(id);
//		System.out.println("Inserted Student =" + savedStudent);
//
//		assertNotNull(savedStudent);
//	}
//
//	@Test
//	public void getStudentById() {
//		Optional<Student> student = studentRepository.findById(2);
//		System.out.println("Student By ID 2 =" + student.get());
//		assertNotNull(student.orElseGet(null));
//	}
//
//	@Test
//	public void getAllStudent() {
//		List<Student> students = studentRepository.findAll();
//		System.out.println(students);
//		System.out.println("Total number of students record" + students.size());
//		assertEquals(4, students.size());
//	}
	
	//Mark testcase
	@Test
	public void getMarksForStudent() {
		Student student=getStudent(2);
		System.out.println("Student =" + student);		
		assertNotNull(student);
	}

	@Test
	public void sumOfStudentMarks() {
		Student student=getStudent(2);
		int sum=student.getMarks().stream().mapToInt(mark ->mark.getMark()).sum();
		assertNotNull(student);
		assertEquals(181, sum);
	}
	
	private Student getStudent(int id) {
		Optional<Student> studentOptional = studentRepository.findById(id);
		return studentOptional.orElseGet(null);
	}
}
