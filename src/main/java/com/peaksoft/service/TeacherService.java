package com.peaksoft.service;

import com.peaksoft.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeacher();
    void addTeacher(Teacher teacher,Long courseId);
    void updateTeacher(Long id,Teacher teacher,Long courseId);
    Teacher getById(Long id);
    void deleteTeacher(Teacher teacher);
}
