package com.peaksoft.controller;

import com.peaksoft.entity.Group;
import com.peaksoft.entity.Student;
import com.peaksoft.service.GroupService;
import com.peaksoft.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("students")
public class StudentController {
    private final GroupService groupService;
    private final StudentService studentService;

    @Autowired
    public StudentController(GroupService groupService, StudentService studentService) {
        this.groupService = groupService;
        this.studentService = studentService;
    }

    @GetMapping
    public String student(Model model) {
        model.addAttribute("students", studentService.getAllStudent());
        return "student/students";
    }

    @GetMapping("/addStudent")
    public String add(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("groups", groupService.getAllGroup());
        return "student/addStudent";
    }
    @PostMapping("/saveStudent")
    public String save(@ModelAttribute("student") Student student) {
        studentService.addStudent(student,student.getGroupId());
        return "redirect:/students";
    }
}
