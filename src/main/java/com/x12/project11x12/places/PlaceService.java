package com.x12.project11x12.places;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    public Place getPlaceById(Long id) {
        return placeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Place with id " + id + " not found"));
    }

    public Place createPlace(Place place) {
        return placeRepository.save(place);
    }

    public Place updatePlace(Long id, Place updatedPlace) {
        Place place = placeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Place with id " + id + " not found"));

        place.setPlaceNumber(updatedPlace.getPlaceNumber());
        place.setSchoolId(updatedPlace.getSchoolId());
        place.setWeekId(updatedPlace.getWeekId());
        place.setCampId(updatedPlace.getCampId());

        return placeRepository.save(place);
    }
}

