package com.learn.crudapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.crudapp.model.Course;
import com.learn.crudapp.repository.CourseRepository;
import com.learn.crudapp.service.CourseService;


@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course getCoursebyId(Long courseId) {
		return courseRepository.findById(courseId).get();
	}

	@Override
	public void deleteCourse(Long courseId) {
		courseRepository.deleteById(courseId);
	}

	@Override
	public List<Course> listCourse(Course course) {
		return courseRepository.findAll();
	}

	@Override
	public Course updateCourse(Long courseId, Course course) {
		Course existingCourse = courseRepository.findById(courseId).get();
		existingCourse.setName(course.getName());
		existingCourse.setDescription(course.getDescription());
		existingCourse.setStatus(course.getStatus());
		existingCourse.setEmail(course.getEmail());

		Course updatedCourse = courseRepository.save(existingCourse);

		return updatedCourse;

	}

}
