package com.x12.project11x12.camp_weeks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api-endpoint}/campweeks")
public class CampWeekController {

  @Autowired
  private CampWeekService campWeekService;
  @GetMapping
  public ResponseEntity<List<CampWeek>> getAllCampWeek(){
    List<CampWeek> campWeeks = campWeekService.gettAllCampWeeks();
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
  
}
