package com.peaksoft.entity;
import lombok.*;
import javax.persistence.*;
import java.util.List;
@Getter@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "date_of_start")
    private String dateOfStart;
    @Column(name = "date_of_finish")
    private String dateOfFinish;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "group")
    private List<Student>students;
    @Transient
    private Long courseId;

}