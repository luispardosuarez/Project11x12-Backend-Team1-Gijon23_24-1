package com.x12.project11x12.places;

import jakarta.persistence.*;

@Entity
@Table(name = "places")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_places")
    private Long id;

    @Column(name = "place_num")
    private int placeNumber;

    @Column(name = "school_id")
    private int schoolId;

    @Column(name = "week_id")
    private int weekId;

    @Column(name = "camp_id")
    private int campId;

    public Place() {
    }

    public Place(int placeNumber, int schoolId, int weekId, int campId) {
        this.placeNumber = placeNumber;
        this.schoolId = schoolId;
        this.weekId = weekId;
        this.campId = campId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public int getWeekId() {
        return weekId;
    }

    public void setWeekId(int weekId) {
        this.weekId = weekId;
    }

    public int getCampId() {
        return campId;
    }

    public void setCampId(int campId) {
        this.campId = campId;
    }
}
