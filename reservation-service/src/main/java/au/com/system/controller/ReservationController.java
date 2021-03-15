package au.com.system.controller;

import au.com.system.model.Guest;
import au.com.system.model.Hotel;
import au.com.system.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;


    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> getHotelList() {
        ResponseEntity<List<Hotel>> hotelList = reservationService.getHotelList();
        return hotelList;
    }

   @GetMapping("/guest")
    public ResponseEntity<List<Hotel>> getGuestlList() {
        ResponseEntity<List<Hotel>> hotelList = reservationService.getHotelList();
        return hotelList;
    }

    @GetMapping("/guest/{id}")
    public ResponseEntity<Guest> getGuestList(@PathVariable Integer id) {
        ResponseEntity<Guest> guest = reservationService.getGuestDetail(id);
        return guest;
    }
}
