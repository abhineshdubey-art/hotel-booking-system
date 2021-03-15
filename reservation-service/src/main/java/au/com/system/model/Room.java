package au.com.system.model;

//import javax.persistence.*;
import java.math.BigDecimal;

//@Entity
//@Table(name = "hotel_room")
public class Room {

 //   @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
 //   @Column(name = "id")
    int id;

  //  @Column(name = "room_name")
    private String roomName;

  //  @Column(name = "descripation")
    private String desc;


   // @OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "type_id")
    private RoomType roomType;

   // @OneToOne(fetch = FetchType.LAZY, optional = true)
   // @JoinColumn(name = "hotel_id", nullable = true)
    private Hotel hotel;

    public Room(){

    }
    public Room(int id, String roomName, String desc, RoomType roomType) {
        this.id = id;
        this.roomName = roomName;
        this.desc = desc;
        this.roomType = roomType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
}
