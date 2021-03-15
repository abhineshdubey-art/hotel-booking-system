package com.guest.controller;

import com.guest.model.Guest;
import com.guest.repository.GuestRepository;
import com.guest.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class GuestController {

    @Autowired
    GuestService guestService;

    @GetMapping("/guest")
    public ResponseEntity<List<Guest>> getGuestList(){
        return guestService.getGuestList();
    }

    @PostMapping("/guest")
    public ResponseEntity<String> registration(@RequestBody Guest guestDetail) {
        return guestService.guestRegistration(guestDetail);
    }

    @GetMapping("/guest/{id}")
    public ResponseEntity<Guest> getGuestDetail(@PathVariable Integer id) {
        return guestService.getGuestDetail(id);
    }

    @PutMapping("/guest/{id}")
    public ResponseEntity<String> updateGuest(@PathVariable Integer id, @RequestBody Guest guestDetail){
        return guestService.updateGuest(id, guestDetail);
    }









}
