package au.com.system.repository;

import au.com.system.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    @Query(value = "select * from Hotel where first_name like %?1", nativeQuery = true)
    List<Hotel> findByCityAndGivenDate(String city);

}
