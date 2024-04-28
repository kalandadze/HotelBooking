package com.example.demo.repository;

import com.example.demo.dto.HotelDto;
import com.example.demo.model.Hotel;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {
}
