package com.x12.project11x12.schools;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.x12.project11x12.inscriptions.Inscription;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "schools")
public class School {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_schools")
    private Long id;

    @Column(name = "school_name")
    private String schoolName;

    @JsonIgnore
    @OneToMany(mappedBy = "schools")
    private Set<Inscription> inscriptions;

    public School() {
    }

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }
}

