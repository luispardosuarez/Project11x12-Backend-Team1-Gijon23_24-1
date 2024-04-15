package com.x12.project11x12.places;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "${api-endpoint}/places")
public class PlaceController {

    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public ResponseEntity<List<Place>> getAllPlaces() {
        List<Place> places = placeService.getAllPlaces();
        return new ResponseEntity<>(places, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Place> getPlaceById(@PathVariable("id") Long id) {
        Place place = placeService.getPlaceById(id);
        return new ResponseEntity<>(place, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Place> createPlace(@RequestBody Place place) {
        Place createdPlace = placeService.createPlace(place);
        return new ResponseEntity<>(createdPlace, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Place> updatePlace(@PathVariable("id") Long id, @RequestBody Place place) {
        Place updatedPlace = placeService.updatePlace(id, place);
        return new ResponseEntity<>(updatedPlace, HttpStatus.OK);
    }

}
