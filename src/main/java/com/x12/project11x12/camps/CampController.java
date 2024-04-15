package com.x12.project11x12.camps;

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
@RequestMapping("${api-endpoint}/camps")
public class CampController {

  @Autowired
  private CampService campService;
  @GetMapping
  public ResponseEntity<List<Camp>> getAllCamp(){
    List<Camp> camp = campService.getAllCamps();
    return ResponseEntity.ok(camp);
  }
  @GetMapping("/{id}")
  public ResponseEntity<Camp> getCampById(@PathVariable Long id){
    Camp camp = campService.getCampById(id);
    if (camp == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(camp);
  }
  @PostMapping
  public ResponseEntity<Camp> createCamp(@RequestBody Camp camp){
    Camp savedCamp = campService.saveCamp(camp);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedCamp);
  }
  @PutMapping("/{id}")
  public ResponseEntity<Camp> updateCamp(@PathVariable Long id, @RequestBody Camp campDetails) {
    Camp camp = campService.getCampById(id);
    if (camp == null) {
      return ResponseEntity.notFound().build();
    }
    camp.setCamp_name(campDetails.getCamp_name());
    camp.setStart_date(campDetails.getStart_date());
    camp.setEnd_date(campDetails.getEnd_date());
    camp.setSchedule(campDetails.getSchedule());
    camp.setDescription(campDetails.getDescription());
    camp.setImg(campDetails.getImg());
    camp.setNumdays(campDetails.getNumdays());
    Camp updateCamp = campService.saveCamp(camp);
    return ResponseEntity.ok(updateCamp);
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCamp(@PathVariable Long id){
    Camp camp = campService.getCampById(id);
    if (camp == null) {
      return ResponseEntity.notFound().build();
    }
    campService.deleteCamp(id);
    return ResponseEntity.noContent().build();
  }
  
}
