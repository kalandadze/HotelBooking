package com.example.demo.dto;

import com.example.demo.model.Room;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class HotelDto {
    private String name;
    private List<RoomDto> rooms;
}
