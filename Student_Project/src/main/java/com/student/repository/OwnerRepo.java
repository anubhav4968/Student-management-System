package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entity.Owner;


public interface OwnerRepo extends JpaRepository<Owner, Integer>{

}
