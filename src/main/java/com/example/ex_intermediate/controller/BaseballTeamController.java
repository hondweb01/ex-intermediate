package com.example.ex_intermediate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ex_intermediate.dto.TeamDTO;
import com.example.ex_intermediate.service.BaseballTeamDataService;

@Controller
@RequestMapping("/baseballteam")
public class BaseballTeamController {
    @Autowired
    BaseballTeamDataService teamDataServiceservice;

    @GetMapping("")
    public String viewTeamList(){
      for(TeamDTO team:teamDataServiceservice.TeamList()){
        System.out.println(team.getTeam_name());
      }
        return "teamList";
    }
    
}
