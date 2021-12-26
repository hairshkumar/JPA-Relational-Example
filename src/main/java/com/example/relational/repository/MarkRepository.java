package com.example.relational.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.relational.entity.Mark;

public interface MarkRepository extends JpaRepository<Mark, Integer> {

	public List<Mark> findBySubjectTitle(String subjectName);
}
