package com.x12.project11x12.camps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampService {

  @Autowired
  private CampRepository campRepository;

  public List <Camp> getAllCamps(){
    return campRepository.findAll();
  }

  public Camp getCampById(Long id){
    return campRepository.findById(id).orElse(null);
  }

  public Camp saveCamp(Camp camp){
    return campRepository.save(camp);
  }

  public void deleteCamp(Long id){
    campRepository.deleteById(id);
  }
  
}
