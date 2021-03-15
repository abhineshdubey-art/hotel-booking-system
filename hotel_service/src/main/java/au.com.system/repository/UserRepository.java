package au.com.system.repository;

import au.com.system.model.Room;
import au.com.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("select u from User u where u.userName = :username")
    public User getUserByName(@Param("username") String username);
}
