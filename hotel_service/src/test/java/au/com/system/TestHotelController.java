package au.com.system;


import au.com.system.controller.HotelController;
import au.com.system.model.Address;
import au.com.system.model.Hotel;
import au.com.system.model.Room;
import au.com.system.model.RoomType;
import au.com.system.service.HotelService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
/*import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;*/


/*import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;*/
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
/*import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.Mockito.doReturn;*/
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.hasSize;


@ExtendWith(SpringExtension.class)
@WebMvcTest(HotelController.class)
public class TestHotelController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    HotelService hotelService;

    @Test
    public void contextLoads() throws Exception {

    }

    @Test
    void testDeleteRoom() throws Exception {
        String uri = "/v1/room/11";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        //MvcResult mvcResult = mockMvc.perform(delete("/v1/room/{roomId}", "11")).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(202, status);
    }


    @Test
    public void testGetHotelList() throws Exception{

        RoomType roomType = new RoomType(1,"1st");
        Room room = new Room(1001,"abc", "good", roomType);
        Address address = new Address();
        Hotel hotel = new Hotel(101, "sayaJi","97867564345",address,room);

        List<Hotel> hotelList = Arrays.asList(hotel);
        Mockito.when(hotelService.getHotelList()).thenReturn(hotelList);

        mockMvc.perform(get("/v1/hotels")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(hotel.getName())));
    }

    @Test
    public void testGetHotelDetails() throws Exception{
        RoomType roomType = new RoomType(1,"1st");
        Room room = new Room(1001,"abc", "good", roomType);
        Address address = new Address();
        Hotel hotel = new Hotel(101, "sayaJi","97867564345",address,room);

        Mockito.when(hotelService.getHotelDetails(101)).thenReturn(java.util.Optional.of(hotel));

        mockMvc.perform(get("/v1/hotels/101")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(hotel.getId())));
    }

}
