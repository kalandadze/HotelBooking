package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotel")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(
            mappedBy = "hotel",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Room> rooms;

    public Hotel(String name, int numOfRooms) {
        this.name = name;
        createRooms(numOfRooms);
    }

    public void createRooms(int numOfRooms){
        this.rooms=new ArrayList<>();
        for (int i=1;i<=numOfRooms;i++){
            Room room=new Room(false,i,this);
            this.rooms.add(room);
        }
    }
//    public int numOfRooms(){
//        return rooms.size();
//    }
//    public int numOfBookedRooms(){
//        int i=0;
//        for (Room room:rooms){
//            if (room.isBooked()){
//                i++;
//            }
//        }
//        return i;
//    }
//    public List<Integer> getActiveRooms(){
//        List<Integer> rooms1=new ArrayList<>();
//        for (Room room:rooms){
//            if (!room.isBooked()){
//                rooms1.add(room.getRoomNum());
//            }
//        }
//        return rooms1;
//    }
}
