package com.learn.crudapp.service;
import com.learn.crudapp.model.Course;
import java.util.List;

public interface CourseService {
	Course createCourse(Course course);
	
	Course updateCourse(Long courseId,Course course);
	
	void deleteCourse(Long courseId);
	
	Course getCoursebyId(Long courseId);
	
	List<Course> listCourse(Course course);
	
	
}
