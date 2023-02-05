package com.peaksoft.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    private String duration;
    @ManyToOne(cascade =CascadeType.REFRESH)
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToMany(cascade =CascadeType.ALL,mappedBy = "course")
    private List<Group>groups;
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.PERSIST})
    private Teacher teacher;
    @Transient
    private Long companyId;
}
