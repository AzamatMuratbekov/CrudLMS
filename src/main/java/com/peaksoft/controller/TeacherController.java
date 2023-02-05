package com.peaksoft.controller;

import com.peaksoft.entity.Student;
import com.peaksoft.entity.Teacher;
import com.peaksoft.service.CourseService;
import com.peaksoft.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("teachers")
public class TeacherController {
    private final TeacherService teacherService;
    private final CourseService courseService;

    @Autowired
    public TeacherController(TeacherService teacherService, CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }

    @GetMapping
    public String student(Model model) {
        model.addAttribute("teachers", teacherService.getAllTeacher());
        return "teacher/teachers";
    }

    @GetMapping("/addTeacher")
    public String add(Model model) {
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("courses", courseService.getAllCourse());
        return "teacher/addTeacher";
    }
    @PostMapping("/saveTeacher")
    public String save(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.addTeacher(teacher,teacher.getCourseId());
        return "redirect:/teachers;";
    }
}