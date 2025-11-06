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
import com.example.ex_intermediate.domain.Hotel;
import com.example.ex_intermediate.dto.SearchHotelDTO;
import com.example.ex_intermediate.form.HotelForm;
import com.example.ex_intermediate.service.SearchHotelsService;

@RequestMapping("/searchbyhotels")
@Controller
public class SearchHotelController {
    @Autowired
    SearchHotelsService service;

    @GetMapping("")
    public String viewHotel(@ModelAttribute("hotelForm") HotelForm hotelForm) {

        return "searchHotel";
    }

    @PostMapping("/sendpriceData")
    public String sendPriceData(@ModelAttribute("hotelForm") HotelForm hotelForm,
            RedirectAttributes redirectAttributes) {
        
            Integer price = hotelForm.getPrice();
            if(price==null){
               List<SearchHotelDTO> allHotelData= service.findAllHotelList();
                redirectAttributes.addFlashAttribute("hotelDataList", allHotelData);
               return "redirect:/searchbyhotels/Amountreflected";
            }

            System.out.println(price);
            List<SearchHotelDTO> hotelData = service.selectPriceHotelList(price);
            redirectAttributes.addFlashAttribute("hotelDataList", hotelData);
            return "redirect:/searchbyhotels/Amountreflected";
  

    }

    @GetMapping("/Amountreflected")
    public String viewHotelAmount(@ModelAttribute("hotelForm") HotelForm hotelForm, Model model) {

        // model.addAttribute("hotelData", model);

        return "searchHotel";
    }

}
