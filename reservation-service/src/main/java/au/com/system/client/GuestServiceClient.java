package au.com.system.client;

import au.com.system.model.Guest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "GUEST-SERVICE")
public interface GuestServiceClient {

    @GetMapping("/v1/guest")
    ResponseEntity<List<Guest>> getGuestList();

    @GetMapping("/v1/guest/{id}")
    ResponseEntity<Guest> getGuestDetails(@PathVariable Integer id);


}
