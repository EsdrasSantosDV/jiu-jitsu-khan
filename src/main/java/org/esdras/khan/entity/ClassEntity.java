package org.esdras.khan.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "class_entity")
public class ClassEntity extends PanacheEntity {


    @Column(name = "instructor", nullable = false)
    public String instructor;

    @Column(name = "class_name", nullable = false)
    public String className;

    @OneToMany(mappedBy = "jiuJitsuClass", fetch = FetchType.EAGER)
    public Set<Classroom> classrooms;


    public ClassEntity() {
    }


    public ClassEntity(String instructor, String className) {
        this.instructor = instructor;
        this.className = className;
    }
}
