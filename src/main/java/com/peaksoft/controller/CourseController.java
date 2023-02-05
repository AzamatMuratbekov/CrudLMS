package com.peaksoft.controller;

import com.peaksoft.entity.Company;
import com.peaksoft.entity.Course;
import com.peaksoft.service.CompanyService;
import com.peaksoft.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    private final CompanyService companyService;
   @Autowired
    public CourseController(CourseService courseService, CompanyService companyService) {
        this.courseService = courseService;
        this.companyService = companyService;
    }
    @GetMapping
    public String course(Model model){
        model.addAttribute("courses",courseService.getAllCourse());
        return "course/courses";
    }
    @GetMapping("/addCourse")
    public String add(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("companies",companyService.getAllCompany());
        return "course/addCourse";
    }

    @PostMapping("/saveCourse")
    public String save(@ModelAttribute("course") Course course) {
        courseService.addCourse(course,course.getCompanyId());
        return "redirect:/courses";
    }
    @GetMapping("update/{id}")
    public String update(@PathVariable("id")Long id, Model model){
        Course course = courseService.getById(id);
        model.addAttribute("companies",companyService.getAllCompany());
        model.addAttribute("course",course);
        return "course/updateCourse";
    }
    @PatchMapping ("/{id}")
    public String updateCourse(@PathVariable("id") Long id,@ModelAttribute("course")Course course){
        courseService.updateCourse(id, course,course.getCompanyId());
        return "redirect:/courses";
    }
}
