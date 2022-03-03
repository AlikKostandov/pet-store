package com.project.pet.store.entities;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "gender")
    private String gender;


    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "description")
    private String description;

    @Lob
    @Column(name = "image", columnDefinition = "MEDIUMBLOB")
    private String image;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinTable(name = "users_pets",
//            joinColumns = @JoinColumn(name = "user_email"),
//            inverseJoinColumns = @JoinColumn(name = "pet_name"))
//    private User owner;
}
