package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomDto {
    private boolean booked;
    private int roomNum;
    private Integer hotel_id;
}
