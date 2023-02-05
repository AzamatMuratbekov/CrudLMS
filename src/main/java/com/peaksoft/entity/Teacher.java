package com.peaksoft.entity;
import lombok.*;

import javax.persistence.*;
@Getter@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    private String email;
    @Column(name = "last_name")
    private String lastName;
    @OneToOne
    private Course course;
    @Transient
    Long courseId;
    }
