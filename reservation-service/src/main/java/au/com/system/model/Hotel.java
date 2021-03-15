package au.com.system.model;

//import javax.persistence.*;
import java.util.List;
import java.util.Set;

//@Entity
//@Table(name = "hotel")
public class Hotel {

 //   @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

   // @Column
    String name;

  //  @Column
    String contact;

  //  @OneToOne(fetch = FetchType.LAZY,
  //          cascade = CascadeType.ALL,
  //          mappedBy = "hotel")
    private Address address;

  //  @OneToOne(fetch = FetchType.LAZY,
  //          cascade = CascadeType.ALL,
  //          mappedBy = "hotel")
    private Room room;

    public Hotel(){

    }

    public Hotel(int id, String name, String contact, Address address, Room room) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
