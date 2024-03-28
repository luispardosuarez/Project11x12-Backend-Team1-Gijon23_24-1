package com.x12.project11x12.profiles;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profiles")
public class Profile {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String profile_name;
  private String profile_surname;
  private String dni;
  private String tlf1;
  private String tlf2;

  public Profile(){
  }

  public Profile(Long id, String profile_name, String profile_surname, String dni, String tlf1, String tlf2) {
    this.id = id;
    this.profile_name = profile_name;
    this.profile_surname = profile_surname;
    this.dni = dni;
    this.tlf1 = tlf1;
    this.tlf2 = tlf2;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getProfile_name() {
    return profile_name;
  }

  public void setProfile_name(String profile_name) {
    this.profile_name = profile_name;
  }

  public String getProfile_surname() {
    return profile_surname;
  }

  public void setProfile_surname(String profile_surname) {
    this.profile_surname = profile_surname;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getTlf1() {
    return tlf1;
  }

  public void setTlf1(String tlf1) {
    this.tlf1 = tlf1;
  }

  public String getTlf2() {
    return tlf2;
  }

  public void setTlf2(String tlf2) {
    this.tlf2 = tlf2;
  }

  

  
}
