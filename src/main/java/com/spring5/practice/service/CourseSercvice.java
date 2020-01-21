package com.spring5.practice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.spring5.practice.model.Course;

@Service
public class CourseSercvice {
//	Course er jonne course 
//	create, edit, show all, getByCourseCode 
//	ei koy ta thaklei hobe

	private static List<Course> courses = new ArrayList<Course>();

	private static final String[] COURSES = { "ENG-1", "MATH-1", "PHY-1", "CHEM-1" };

	public CourseSercvice() {
		Stream.of(COURSES).forEach(course -> {
			addCourse(course);
		});
	}

	private void addCourse(String courseName) {
		var courseObj = new Course();
		courseObj.setCourseId(courses.size() + 1);
		courseObj.setCourseName(courseName);
		courses.add(courseObj);
	}

//	
//	

	public void addCourse(Course course) {
		checkCourseInList(course);
		course.setCourseId(courses.size() + 1);
		courses.add(course);
	}

	private void checkCourseInList(Course c) {
		if (courses.stream().filter(course -> course.getCourseName().equals(c.getCourseName())).findAny().isPresent()) {
			throw new RuntimeException("Course already exists in list");
		}
	}

	public Course getCourseByName(String courseName) {

		return courses.stream().filter(course -> course.getCourseName().equals(courseName)).findAny()
				.orElseThrow(() -> new RuntimeException("Course not found with this code"));
	}

	public List<Course> getAll() {
		return courses;
	}

}
