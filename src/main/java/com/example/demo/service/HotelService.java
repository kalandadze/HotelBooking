package com.example.demo.service;

import com.example.demo.dto.HotelCollectionDto;
import com.example.demo.dto.HotelCreationRequestModel;
import com.example.demo.dto.HotelDto;
import com.example.demo.model.Hotel;
import com.example.demo.repository.HotelRepository;
import com.example.demo.util.ModelConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    HotelRepository repo;
    ModelConverter converter;

    @Autowired
    public HotelService(HotelRepository repo, ModelConverter converter) {
        this.repo = repo;
        this.converter = converter;
    }

    public void addHotel(HotelCreationRequestModel hotelCreationReq){
        repo.save(converter.convert(hotelCreationReq));
    }

    public HotelCollectionDto getHotelList() throws JsonProcessingException {
        return converter.convert(findAll());
    }
    private List<Hotel> findAll(){
        return repo.findAll();
    }
}
