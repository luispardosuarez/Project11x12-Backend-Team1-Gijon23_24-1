package com.x12.project11x12.camp_weeks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api-endpoint}/campweeks")
public class CampWeekController {

  @Autowired
  private CampWeekService campWeekService;
  @GetMapping
  public ResponseEntity<List<CampWeek>> getAllCampWeek(){
    List<CampWeek> campWeeks = campWeekService.getAllCampWeeks();
    return ResponseEntity.ok(campWeeks);
  }
  @GetMapping("/{id}")
  public ResponseEntity<CampWeek> getCampWeekById(@PathVariable Long id){
    CampWeek campWeek = campWeekService.getCampWeekById(id);
    if (campWeek == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(campWeek);
  }
  @PostMapping
  public ResponseEntity<CampWeek> createCampWeek(@RequestBody CampWeek campWeek){
    CampWeek savedCampWeek = campWeekService.saveCampWeek(campWeek);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedCampWeek);
  }
  @PutMapping("/{id}")
  public ResponseEntity<CampWeek> updateCampWeek(@PathVariable Long id, @RequestBody CampWeek campWeekDetails) {
    CampWeek campWeek = campWeekService.getCampWeekById(id);
    if (campWeek == null) {
      return ResponseEntity.notFound().build();
    }
    campWeek.setStart_date(campWeekDetails.getStart_date());
    campWeek.setEnd_date(campWeekDetails.getEnd_date());
    campWeek.setCamp_id(campWeekDetails.getCamp_id());
    CampWeek updateCampWeek = campWeekService.saveCampWeek(campWeek);
    return ResponseEntity.ok(updateCampWeek);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCampWeek(@PathVariable Long id){
    CampWeek campWeek = campWeekService.getCampWeekById(id);
    if (campWeek == null) {
      return ResponseEntity.notFound().build();
    }
    campWeekService.deleteCampWeek(id);
    return ResponseEntity.noContent().build();
  }
  
}
