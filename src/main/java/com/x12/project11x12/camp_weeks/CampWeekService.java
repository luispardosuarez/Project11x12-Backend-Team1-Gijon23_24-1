package com.x12.project11x12.camp_weeks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampWeekService {

  @Autowired
  private CampWeekRepository campWeekRepository;

  public List <CampWeek> getAllCampWeeks(){
    return campWeekRepository.findAll();
  }

  public CampWeek getCampWeekById(Long id){
    return campWeekRepository.findById(id).orElse(null);
  }

  public CampWeek saveCampWeek(CampWeek campWeek){
    return campWeekRepository.save(campWeek);
  }

  public void deleteCampWeek(Long id){
    campWeekRepository.deleteById(id);
  }

}
