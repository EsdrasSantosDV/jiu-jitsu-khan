package org.esdras.khan.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table(name = "classroom_entity")
public class Classroom extends PanacheEntity {


    @ManyToOne
    @JoinColumn(name = "jiu_jitsu_class_id", nullable = false)
    public ClassEntity jiuJitsuClass;

    @Column(name = "start_time", nullable = false)
    public LocalDateTime startTime;

    @OneToMany(mappedBy = "classroom")
    public Set<Presence> presences;


    public Classroom() {
    }


    public Classroom(ClassEntity jiuJitsuClass, LocalDateTime startTime) {
        this.jiuJitsuClass = jiuJitsuClass;
        this.startTime = startTime;
    }
}