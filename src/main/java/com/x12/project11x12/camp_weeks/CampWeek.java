package com.x12.project11x12.camp_weeks;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "camp_weeks")
public class CampWeek {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column (name = "id_week")
  private Long id;

  

  
}
