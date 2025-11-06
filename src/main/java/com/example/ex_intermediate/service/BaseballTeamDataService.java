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
    
    /**
     * repositryの TeamListメソッドを呼ぶ
     * @return 全体のチームデータを返す
     */

    public List<TeamDTO> TeamList() {
        return repository.TeamList();
    }
    
    /**
     * idを指定してrepositryの loadTeamメソッドを呼ぶ
     * @param id チームのid
     * @return チームの詳細データを取得
     */
    public TeamDTO loadTeam(Integer id) {
      
        return repository.loadTeam(id);
    }

}
