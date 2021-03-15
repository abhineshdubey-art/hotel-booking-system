package au.com.system.client;

import au.com.system.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelServiceClient {
    @GetMapping("/v1/hotels")
    ResponseEntity<List<Hotel>> getHotelList();
}
