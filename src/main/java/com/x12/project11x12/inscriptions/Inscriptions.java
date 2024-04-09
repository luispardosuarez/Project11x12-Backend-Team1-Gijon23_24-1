package com.x12.project11x12.inscriptions;

import java.util.Date;
import java.util.Set;

import com.x12.project11x12.inscriptions_participants.InscriptionsParticipants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
    // ***** LUIS ****   private Schools schools;

    @ManyToMany
    @JoinTable(
        name = "inscriptions_participants",
        joinColumns = @JoinColumn(name = "inscription_id"),
        inverseJoinColumns = @JoinColumn(name = "participant_id")
    )
    private Set<InscriptionsParticipants> participants;
/* 
    @ManyToOne
    @JoinColumn(name = "inscription_id")
    private Inscriptions inscription; */


    public Inscriptions() {
    }
    
    public Inscriptions(Long id, Integer school_id, Date inscription_date, Integer week_id,
            Set<InscriptionsParticipants> participants) {
        this.id = id;
        this.school_id = school_id;
        this.inscription_date = inscription_date;
        this.week_id = week_id;
        this.participants = participants;
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

    public Set<InscriptionsParticipants> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<InscriptionsParticipants> participants) {
        this.participants = participants;
    }




 





    
}
