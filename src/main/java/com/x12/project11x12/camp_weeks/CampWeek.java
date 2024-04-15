package com.x12.project11x12.camp_weeks;

import java.util.Date;

import com.x12.project11x12.camps.Camp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "camp_weeks")
public class CampWeek {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column (name = "id_week")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_camp")
  private Camp camp;

  private Date start_date;
  private Date end_date;
  private Integer camp_id;

  public CampWeek(){
  }

  public CampWeek(Long id, Date start_date, Date end_date, Integer camp_id) {
    this.id = id;
    this.start_date = start_date;
    this.end_date = end_date;
    this.camp_id = camp_id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getStart_date() {
    return start_date;
  }

  public void setStart_date(Date start_date) {
    this.start_date = start_date;
  }

  public Date getEnd_date() {
    return end_date;
  }

  public void setEnd_date(Date end_date) {
    this.end_date = end_date;
  }

  public Integer getCamp_id() {
    return camp_id;
  }

  public void setCamp_id(Integer camp_id) {
    this.camp_id = camp_id;
  }

  

  

  


  
}
