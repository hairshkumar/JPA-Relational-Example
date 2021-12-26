package com.example.relational.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.relational.entity.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer>{

}
