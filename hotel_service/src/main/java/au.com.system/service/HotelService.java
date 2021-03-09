package au.com.system.service;

import au.com.system.model.Hotel;
import au.com.system.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface HotelService {

    List<Hotel> getHotelList();

    Optional<Hotel> getHotelDetails(Integer id);

    Room createRoom(Room newRoom);

     void deleteRoom(Integer roomId);
}
