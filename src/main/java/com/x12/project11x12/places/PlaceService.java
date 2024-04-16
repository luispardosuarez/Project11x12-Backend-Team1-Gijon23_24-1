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
        return placeRepository.findById(id).orElse(null);
    }

    public Place createPlace(Place place) {
        return placeRepository.save(place);
    }

    public Place updatePlace(Long id, Place updatedPlace) {
        Place existingPlace = placeRepository.findById(id).orElse(null);
        if (existingPlace != null) {
            existingPlace.setPlaceNumber(updatedPlace.getPlaceNumber());
            existingPlace.setSchoolId(updatedPlace.getSchoolId());
            existingPlace.setWeekId(updatedPlace.getWeekId());
            existingPlace.setCampId(updatedPlace.getCampId());
            return placeRepository.save(existingPlace);
        } else {
            return null;
        }
    }

    public void deletePlace(Long id) {
        placeRepository.deleteById(id);
    }
}



