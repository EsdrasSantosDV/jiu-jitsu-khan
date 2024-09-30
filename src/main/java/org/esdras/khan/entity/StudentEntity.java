package org.esdras.khan.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "student_entity")
public class StudentEntity extends PanacheEntity {


    @Column(name = "name", nullable = false)
    public String name;

    @ManyToMany
    public Set<ClassEntity> classes;

    @Enumerated(EnumType.STRING)
    @Column(name = "belt_rank", nullable = false)
    public BeltRank beltRank;

    @Column(name = "degree", nullable = false)
    public int degree;

    public StudentEntity() {
    }


    public StudentEntity(String name, BeltRank beltRank, int degree) {
        this.name = name;
        this.beltRank = beltRank;
        this.degree = degree;
    }
}