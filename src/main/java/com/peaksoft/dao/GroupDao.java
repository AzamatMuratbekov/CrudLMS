package com.peaksoft.dao;

import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;

import java.util.List;

public interface GroupDao {
    List<Group> getAllGroup();
    void addGroup(Group group);
    void updateGroup(Long id,Group group);
    Group getById(Long id);
    void deleteGroup(Group group);
}

