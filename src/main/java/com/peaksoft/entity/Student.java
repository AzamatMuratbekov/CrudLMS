package com.peaksoft.entity;
import lombok.*;
import javax.persistence.*;
@Getter@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Enumerated(EnumType.STRING)
    private StadyFormat stadyFormat;
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "group_id")
    private Group group;
    @Transient
    private Long groupId;
}