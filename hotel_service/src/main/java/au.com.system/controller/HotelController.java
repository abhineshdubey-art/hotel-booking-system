package au.com.system.controller;

import au.com.system.model.Hotel;
import au.com.system.model.Room;
import au.com.system.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class HotelController {

    @Autowired
    private HotelService hotelservice;

    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> getHotelList() {
        List<Hotel> hotelList = hotelservice.getHotelList();
        return ResponseEntity.ok(hotelList);
    }

    @GetMapping("/hotels/{id}")
    public ResponseEntity<Hotel> getHotelDetails(@PathVariable Integer id) {
        Optional<Hotel> hotel = hotelservice.getHotelDetails(id);
        if(hotel.isPresent()){
            return ResponseEntity.ok(hotel.get());
        }else{
            throw new ResourceNotFoundException("Hotel not found");
        }
    }

    @PostMapping("/room")
    public ResponseEntity<String> createNewRoom(@RequestBody Room newRoom) {
        Room room = hotelservice.createRoom(newRoom);
        if(room!=null){
            return new ResponseEntity<String>("Created", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<String>("Not created", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/room/{roomId}")
    public ResponseEntity<String> deleteRoom(@PathVariable Integer roomId){
        if(roomId!=null){
            hotelservice.deleteRoom(roomId);
            return new ResponseEntity<String>("Deleted", HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<String>("Not deleted", HttpStatus.BAD_REQUEST);
        }
    }

}
