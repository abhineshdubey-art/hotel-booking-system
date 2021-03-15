package com.guest.service;

import com.guest.model.Guest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GuestService {

    ResponseEntity<String> guestRegistration(Guest guest);

    ResponseEntity<List<Guest>> getGuestList();

    ResponseEntity<Guest> getGuestDetail(Integer guestId);

    ResponseEntity<String> updateGuest(Integer guestId, Guest guest);
}
