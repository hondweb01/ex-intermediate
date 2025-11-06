package com.example.ex_intermediate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/searchprice")
public class SearchHotelController {
    @GetMapping("")
    public String viewSearchPrice() {
        return "search";

    }

}
