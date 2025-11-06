package com.example.ex_intermediate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ex_intermediate.dto.SearchHotelDTO;
import com.example.ex_intermediate.service.SearchHotelsService;

@RequestMapping("/searchbyhotels")
@Controller
public class SearchHotelController {
    @Autowired
    SearchHotelsService service;

    @GetMapping("")
    public String viewHotel() {

        
        return "searchHotel";
    }

    @PostMapping("/sendpriceData")
    public String sendPriceData(String strPrice,RedirectAttributes redirectAttributes){
        Integer price=Integer.parseInt(strPrice);
        System.out.println(price);
       List<SearchHotelDTO> hotelData= service.selectPriceHotelList(price);
       redirectAttributes.addFlashAttribute("hotelData",hotelData);



        return "redirect:/searchbyhotels/Amountreflected";
    }
    @GetMapping("/Amountreflected")
    public String viewHotel(Model model) {
      
        // model.addAttribute("hotelData", model);
        
        return "searchHotel";
    }

}
