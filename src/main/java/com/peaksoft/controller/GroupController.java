package com.peaksoft.controller;

import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;
import com.peaksoft.service.CourseService;
import com.peaksoft.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;
    private final CourseService courseService;

    @Autowired
    public GroupController(GroupService groupService, CourseService courseService) {
        this.groupService = groupService;
        this.courseService = courseService;
    }

    @GetMapping
    public String group(Model model) {
        model.addAttribute("groups", groupService.getAllGroup());
        return "group/groups";
    }

    @GetMapping("/addGroup")
    public String add(Model model) {
        model.addAttribute("group", new Group());
        model.addAttribute("courses", courseService.getAllCourse());
        return "group/addGroup";
    }
    @PostMapping("/saveGroup")
    public String save(@ModelAttribute("group") Group group) {
        groupService.addGroup(group,group.getCourseId());
        return "redirect:/groups";
    }
}
