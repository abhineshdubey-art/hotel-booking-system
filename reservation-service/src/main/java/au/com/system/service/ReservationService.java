package au.com.system.service;

import au.com.system.model.Guest;
import au.com.system.model.Hotel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReservationService {

    ResponseEntity<List<Hotel>> getHotelList();

    ResponseEntity<List<Guest>> getGuestList();

    ResponseEntity<Guest> getGuestDetail(Integer id);
}
