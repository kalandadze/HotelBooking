package com.example.demo.controller;

import com.example.demo.dto.HotelCollectionDto;
import com.example.demo.dto.HotelCreationRequestModel;
import com.example.demo.dto.HotelDto;
import com.example.demo.service.HotelService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    HotelService service;

    @Autowired
    public HotelController(HotelService service) {
        this.service = service;
    }

    @PostMapping
    public void addHotel(@RequestBody HotelCreationRequestModel hotel) throws JsonProcessingException {
        service.addHotel(hotel);
    }
    @GetMapping
    @ResponseBody
    public HotelCollectionDto getHotelList() throws JsonProcessingException {
        return service.getHotelList();
    }
}
