package com.learn.crudapp.controller;

import lombok.AllArgsConstructor;
import com.learn.crudapp.model.Course;
import com.learn.crudapp.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/course")

public class CourseController {

	@Autowired
	private CourseService courseService;

	@PostMapping
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
		System.out.print("testing");
		Course savedCourse = courseService.createCourse(course);
		return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<Course>> listCourse(@RequestBody Course course) {
		List<Course> savedCourse = courseService.listCourse(course);
		return new ResponseEntity<>(savedCourse, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable("id") Long courseId) {
		Course course = courseService.getCoursebyId(courseId);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Course> createCourse(@PathVariable("id") int courseId, @RequestBody Course course) {

		course.setId(courseId);
		Course savedCourse = courseService.createCourse(course);
		return new ResponseEntity<>(savedCourse, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable("id") Long courseId) {
		courseService.deleteCourse(courseId);
		return new ResponseEntity<>("Course Deleted Successfully", HttpStatus.OK);
	}

}
