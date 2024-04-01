package com.x12.project11x12.profiles;

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
@RequestMapping("${api-endpoint}/profile")
public class ProfileController {

  @Autowired
  private ProfileService profileService;
    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfile(){
      List<Profile> profile = profileService.getAllProfile();
      return ResponseEntity.ok(profile);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
      Profile profile = profileService.getProfileById(id);
      if (profile == null) {
        return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(profile);
    }
    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
      Profile savedProfile = profileService.saveProfile(profile);
      return ResponseEntity.status(HttpStatus.CREATED).body(savedProfile);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profileDetails) {
      Profile profile = profileService.getProfileById(id);
      if (profile == null) {
        return ResponseEntity.notFound().build();
      }
      profile.setProfile_name(profileDetails.getProfile_name());
      profile.setProfile_surname(profileDetails.getProfile_surname());
      profile.setDni(profileDetails.getDni());
      profile.setTlf1(profileDetails.getTlf1());
      profile.setTlf2(profileDetails.getTlf2());
      Profile updateProfile = profileService.saveProfile(profile);
      return ResponseEntity.ok(updateProfile);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
      Profile profile = profileService.getProfileById(id);
      if (profile == null) {
        return ResponseEntity.notFound().build();
      }
      profileService.deleteProfile(id);
      return ResponseEntity.noContent().build();
    }
  
}
