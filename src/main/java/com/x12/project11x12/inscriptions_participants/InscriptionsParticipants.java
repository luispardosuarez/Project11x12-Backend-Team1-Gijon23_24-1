package com.x12.project11x12.inscriptions_participants;

import com.x12.project11x12.inscriptions.Inscriptions;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inscriptions_participants")
public class InscriptionsParticipants {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ins_part")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "inscription_id")
    private Inscriptions inscription;
    
    @Column
    private Integer participant_id; 

    @Column
    private Integer inscription_id;

    @Column
    private Boolean breakfast;

    @Column
    private Boolean snak;

    @Column
    private String allergies;

    @Column
    private String remarks;

    @Column
    private Integer invoice;

    public InscriptionsParticipants() {
    }

    public InscriptionsParticipants(Long id, Inscriptions inscription, Integer participant_id, Integer inscription_id,
            Boolean breakfast, Boolean snak, String allergies, String remarks, Integer invoice) {
        this.id = id;
        this.inscription = inscription;
        this.participant_id = participant_id;
        this.inscription_id = inscription_id;
        this.breakfast = breakfast;
        this.snak = snak;
        this.allergies = allergies;
        this.remarks = remarks;
        this.invoice = invoice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Inscriptions getInscription() {
        return inscription;
    }

    public void setInscription(Inscriptions inscription) {
        this.inscription = inscription;
    }

    public Integer getParticipant_id() {
        return participant_id;
    }

    public void setParticipant_id(Integer participant_id) {
        this.participant_id = participant_id;
    }

    public Integer getInscription_id() {
        return inscription_id;
    }

    public void setInscription_id(Integer inscription_id) {
        this.inscription_id = inscription_id;
    }

    public Boolean getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Boolean breakfast) {
        this.breakfast = breakfast;
    }

    public Boolean getSnak() {
        return snak;
    }

    public void setSnak(Boolean snak) {
        this.snak = snak;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getInvoice() {
        return invoice;
    }

    public void setInvoice(Integer invoice) {
        this.invoice = invoice;
    }


    



    
    
}
