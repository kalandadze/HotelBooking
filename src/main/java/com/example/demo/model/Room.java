package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Integer roomId;
    @Column(name = "booked")
    private boolean booked;
    @Column(name = "room_num")
    private int roomNum;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Room(boolean booked, int roomNum, Hotel hotel) {
        this.booked = booked;
        this.roomNum = roomNum;
        this.hotel = hotel;
    }
}
