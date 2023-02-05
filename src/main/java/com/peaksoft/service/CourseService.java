package com.peaksoft.service;

import com.peaksoft.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();
    void addCourse(Course course,Long companyId);
    void updateCourse(Long id,Course course,Long companyId);
    Course getById(Long id);
    void deleteCourse(Course course);
}
