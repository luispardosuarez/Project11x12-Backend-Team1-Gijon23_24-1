package com.x12.project11x12.profiles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

  @Autowired
  private ProfileRepository profileRepository;

  public List <Profile> getAllProfile(){
    return profileRepository.findAll();
  }

  public Profile getProfileById(Long id){
    return profileRepository.findById(id).orElse(null);
  }

  public Profile saveProfile(Profile profile){
    return profileRepository.save(profile);
  }

  public void deleteProfile(Long id){
    profileRepository.deleteById(id);
  }
  
}
