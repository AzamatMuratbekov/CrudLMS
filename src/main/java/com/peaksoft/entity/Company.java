package com.peaksoft.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "located_country")
    private String locatedCountry;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
    private List<Course>courses;
}
