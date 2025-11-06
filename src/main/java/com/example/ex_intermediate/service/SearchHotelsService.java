package com.example.ex_intermediate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ex_intermediate.dto.SearchHotelDTO;
import com.example.ex_intermediate.repository.SearchHotelsRepository;

@Service
public class SearchHotelsService {
    @Autowired
    SearchHotelsRepository repository;
public List<SearchHotelDTO> selectPriceHotelList(Integer price){
    System.out.println("値段"+price);
    return repository.selectPriceHotelList(price);

}
    
    
}
