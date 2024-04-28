package com.example.demo.util;

import com.example.demo.dto.HotelCollectionDto;
import com.example.demo.dto.HotelCreationRequestModel;
import com.example.demo.dto.HotelDto;
import com.example.demo.dto.RoomDto;
import com.example.demo.model.Hotel;
import com.example.demo.model.Room;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModelConverter {
    private RoomDto convert(Room room){
        return RoomDto.builder()
                .booked(room.isBooked())
                .hotel_id(room.getHotel().getId())
                .roomNum(room.getRoomNum())
                .build();
    }
    public HotelDto convert(Hotel hotel){
        return HotelDto.builder()
                .name(hotel.getName())
                .rooms(hotel.getRooms().stream().map(this::convert).toList())
                .build();
    }
    public HotelCollectionDto convert(List<Hotel> hotels){
        return HotelCollectionDto.builder()
                .hotelDtoList(hotels.stream().map(this::convert).toList())
                .build();
    }
    public Hotel convert(HotelCreationRequestModel hotelCreationReq){
        Hotel hotel=Hotel.builder().name(hotelCreationReq.getName()).build();
        hotel.createRooms(hotelCreationReq.getNumOfRooms());
        return hotel;
    }
}
