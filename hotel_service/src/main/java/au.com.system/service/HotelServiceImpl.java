package au.com.system.service;

import au.com.system.model.Hotel;
import au.com.system.model.Room;
import au.com.system.repository.HotelRepository;
import au.com.system.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepo;

    @Autowired
    private RoomRepository roomRepo;

    @Override
    public List<Hotel> getHotelList() {
        return hotelRepo.findAll();
    }

    public Optional<Hotel> getHotelDetails(Integer id) {
        return hotelRepo.findById(id);
    }

    public Room createRoom(Room newRoom) {
        return roomRepo.save(newRoom);
    }

    public void deleteRoom(Integer roomId){
        roomRepo.deleteById(roomId);
    }
}
