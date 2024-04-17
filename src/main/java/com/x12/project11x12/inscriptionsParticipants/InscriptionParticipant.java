package com.x12.project11x12.inscriptionsParticipants;

import com.x12.project11x12.inscriptions.Inscriptions;
import com.x12.project11x12.participants.Participant;

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
public class InscriptionParticipant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ins_part")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "inscription_id")
    private Inscriptions inscriptions;
    
    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participants;

    @Column
    private Boolean breakfast;

    @Column
    private Boolean snack;

    @Column
    private String allergies;

    @Column
    private String remarks;

    @Column
    private Integer invoice;

    public InscriptionParticipant() {
    }

    public InscriptionParticipant(Long id, Inscriptions inscriptions, Participant participants, Boolean breakfast,
            Boolean snack, String allergies, String remarks, Integer invoice) {
        this.id = id;
        this.inscriptions = inscriptions;
        this.participants = participants;
        this.breakfast = breakfast;
        this.snack = snack;
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

    public Inscriptions getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Inscriptions inscriptions) {
        this.inscriptions = inscriptions;
    }

    public Participant getParticipants() {
        return participants;
    }

    public void setParticipants(Participant participants) {
        this.participants = participants;
    }

    public Boolean getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Boolean breakfast) {
        this.breakfast = breakfast;
    }

    public Boolean getSnak() {
        return snack;
    }

    public void setSnak(Boolean snack) {
        this.snack = snack;
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
