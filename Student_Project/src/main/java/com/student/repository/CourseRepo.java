package com.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entity.Course;
import com.student.entity.Student;

public interface CourseRepo extends JpaRepository<Course, Integer>{

//	List<Course> getAllCourseOfStudent(Student student);
}
