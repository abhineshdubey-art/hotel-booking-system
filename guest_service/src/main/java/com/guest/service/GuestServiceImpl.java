package com.guest.service;

import com.guest.controller.ResourceNotFoundException;
import com.guest.model.Guest;
import com.guest.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    GuestRepository guestRepository;

    public ResponseEntity<String> guestRegistration(Guest guestDetail){
        Guest guest =  guestRepository.save(guestDetail);
        if(guest!=null){
            return new ResponseEntity<String>("Registration done", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<String>("Registration failed", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Guest>> getGuestList(){
        return ResponseEntity.ok(guestRepository.findAll());
    }

    public ResponseEntity<Guest> getGuestDetail(Integer guestId){
        Optional<Guest> guest = guestRepository.findById(guestId);
        if(guest.isPresent()){
            return ResponseEntity.ok(guest.get());
        }else{
            throw new ResourceNotFoundException("Guest not found");
        }
    }

    public ResponseEntity<String> updateGuest(Integer guestId, Guest guest){
        Optional<Guest> guestDetail = guestRepository.findById(guestId);
        if (guestDetail.isPresent()){
            Guest guestUser = guestDetail.get();
            guestUser.setAddress(guest.getAddress());
            guestUser.setEmailId(guest.getEmailId());
            guestUser.setFirstName(guest.getFirstName());
            guestUser.setLastName(guest.getLastName());
            guestUser.setPhoneNo(guest.getPhoneNo());

            guest =  guestRepository.save(guestUser);

            if(guest!=null){
                return new ResponseEntity<String>("Guest details updated", HttpStatus.CREATED);
            }else{
                return new ResponseEntity<String>("Updation failed", HttpStatus.BAD_REQUEST);
            }

        }else{
            throw new ResourceNotFoundException("Guest not present in table");
        }
    }

}
