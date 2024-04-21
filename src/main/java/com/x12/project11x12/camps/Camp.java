package com.x12.project11x12.camps;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "camps")
public class Camp {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column (name = "id_camp")
  private Long id;

  private String camp_name;
  private Date start_date;
  private Date end_date;
  private String schedule;

  @Column(columnDefinition = "TEXT")
  private String description;

  private String img;
  private Integer numdays;
  private Integer price;

  public Camp(){
  }

  public Camp(Long id, String camp_name, Date start_date, Date end_date, String schedule, String description,
      String img, Integer numdays, Integer price) {
    this.id = id;
    this.camp_name = camp_name;
    this.start_date = start_date;
    this.end_date = end_date;
    this.schedule = schedule;
    this.description = description;
    this.img = img;
    this.numdays = numdays;
    this.price = price;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCamp_name() {
    return camp_name;
  }

  public void setCamp_name(String camp_name) {
    this.camp_name = camp_name;
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

  public String getSchedule() {
    return schedule;
  }

  public void setSchedule(String schedule) {
    this.schedule = schedule;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public Integer getNumdays() {
    return numdays;
  }

  public void setNumdays(Integer numdays) {
    this.numdays = numdays;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }



}
