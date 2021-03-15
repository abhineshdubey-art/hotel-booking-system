package au.com.system.service;

import au.com.system.client.GuestServiceClient;
import au.com.system.client.HotelServiceClient;
import au.com.system.model.Guest;
import au.com.system.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private HotelServiceClient hotelServiceClient;

    @Autowired
    private GuestServiceClient guestServiceClient;

    public ResponseEntity<List<Hotel>> getHotelList(){
        ResponseEntity<List<Hotel>> hotelList = hotelServiceClient.getHotelList();
        return hotelList;
    }

    public ResponseEntity<List<Guest>> getGuestList(){
        return guestServiceClient.getGuestList();
    }

    public ResponseEntity<Guest> getGuestDetail(Integer id){
        return guestServiceClient.getGuestDetails(id);
    }
}
