package com.example.ex_intermediate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ex_intermediate.dto.TeamDTO;
import com.example.ex_intermediate.repository.BaseballTeamDataRepository;

@Service
public class BaseballTeamDataService {
    @Autowired
    BaseballTeamDataRepository repository;

    public TeamDTO viewBaseballTeamData(Integer id){
        return repository.loadTeam(id);
    }
    public List<TeamDTO> TeamList(){
       return repository.TeamList();
    }

    
}
