package com.example.relational.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.relational.entity.Mark;
import com.example.relational.entity.Subject;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MarkRepositoryTest {

	@Autowired
	MarkRepository markRepository;
	
	@Autowired
	SubjectRepository subjectRepository;

	@Test
	public void getAllMArks() {
		List<Mark> marks = markRepository.findAll();
		System.out.println(marks);
		assertEquals(12, marks.size());
	}

	@Test
	public void insertMark() {
		Subject subject = subjectRepository.getById(1);

		Mark mark = Mark.builder().subject(subject).studentid(5).mark(60).build();
		Mark markInDB = markRepository.save(mark);
		
		System.out.println(markInDB);
		assertNotNull(markInDB);
	}

	@Test
	public void getMarksBySubjectTitle() {
		List<Mark> marks = markRepository.findBySubjectTitle("Java");
		System.out.println(marks);
		assertEquals(4, marks.size());
	}
}
