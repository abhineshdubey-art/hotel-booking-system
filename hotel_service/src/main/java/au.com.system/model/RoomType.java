package au.com.system.model;

import javax.persistence.*;

@Entity
@Table(name = "room_type")
public class RoomType {

    @Id
    @Column(name = "id")
    int id;

    @Column
    String type;

    @OneToOne(mappedBy = "roomType")
    private Room room;

    public RoomType(){

    }
    public RoomType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
