package au.com.system.controller;

import au.com.system.config.JwtTokenUtil;
import au.com.system.model.*;
import au.com.system.service.HotelService;
import au.com.system.service.MyUserDetailsService;
import au.com.system.util.JwtUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class HotelController {

    @Autowired
    private HotelService hotelservice;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    MyUserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtUtil;


    @GetMapping("/hotels")
    @HystrixCommand(fallbackMethod = "fallbackgetHotelList")
    public ResponseEntity<List<Hotel>> getHotelList() {
        List<Hotel> hotelList = hotelservice.getHotelList();
        return ResponseEntity.ok(hotelList);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
       try {
           authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                   authenticationRequest.getPassword()));
       }catch(BadCredentialsException e){
            throw new Exception("Incorrect username or password" , e);
       }

       final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }


    public ResponseEntity<List<Hotel>> fallbackgetHotelList(){
        Address address = new Address();
        Room room = new Room();
        List<Hotel> hotelList = Arrays.asList(new Hotel(101, "raj ratan", "76857484736", address,room));
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
