package com.project.pet.store.entities;


import lombok.*;

import javax.persistence.*;


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
    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User owner;
}
