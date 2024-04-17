package com.x12.project11x12.inscriptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.x12.project11x12.inscriptionsParticipants.InscriptionParticipant;
import com.x12.project11x12.schools.School;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.x12.project11x12.camp_weeks.CampWeek;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inscriptions")
public class Inscriptions {

    @Id   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscription")
    private Long id;

    @Column
    private Integer school_id;
    
    @Column
    private Date inscription_date;

    @Column
    private Integer week_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_schools")
    private School school;

    @OneToOne
    @JoinColumn(name = "id_week") 
    private CampWeek campWeeks;

    @JsonIgnore
    @OneToMany(mappedBy = "inscriptions", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InscriptionParticipant> inscriptionParticipant = new ArrayList<>();


    public Inscriptions() {
    }

    public Inscriptions(Long id, Integer school_id, Date inscription_date, Integer week_id,
            List<InscriptionParticipant> inscriptionParticipant) {
        this.id = id;
        this.school_id = school_id;
        this.inscription_date = inscription_date;
        this.week_id = week_id;
        this.inscriptionParticipant = inscriptionParticipant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSchool_id() {
        return school_id;
    }

    public void setSchool_id(Integer school_id) {
        this.school_id = school_id;
    }

    public Date getInscription_date() {
        return inscription_date;
    }

    public void setInscription_date(Date inscription_date) {
        this.inscription_date = inscription_date;
    }

    public Integer getWeek_id() {
        return week_id;
    }

    public void setWeek_id(Integer week_id) {
        this.week_id = week_id;
    }

    public List<InscriptionParticipant> getInscriptionParticipant() {
        return inscriptionParticipant;
    }

    public void setInscriptionParticipant(List<InscriptionParticipant> inscriptionParticipant) {
        this.inscriptionParticipant = inscriptionParticipant;
    }
 
}
