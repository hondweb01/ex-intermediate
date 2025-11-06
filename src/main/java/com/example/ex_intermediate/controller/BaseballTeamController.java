package com.example.ex_intermediate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.ex_intermediate.dto.TeamDTO;
import com.example.ex_intermediate.service.BaseballTeamDataService;

@Controller
@RequestMapping("/baseballteam")
public class BaseballTeamController {
    @Autowired
    BaseballTeamDataService teamDataServiceservice;

    /**
     * @param teamList DBから取得したチームのデータを格納している
     * @return "teamList" 球団一覧画面
     * 
     */
    @GetMapping("")
    public String viewTeamList(Model model) {
        List<TeamDTO> teamList = teamDataServiceservice.TeamList();
        model.addAttribute("teamList", teamList);
        return "teamList";
    }

    /**
     * 
     * @param strteamId   パスから取得した各チームのid（String型）
     * @param historyData 歴史の流れは縦方向に記述するため、splitで分割するため使用
     * @return teamdetailData チームデータの詳細画面 
     */

    @GetMapping("/teamdetailview/{teamId}")
    public String sendDetailTeamData(@PathVariable("teamId") String strteamId, Model model) {
        try {
            Integer id = Integer.parseInt(strteamId);

            TeamDTO teamData = teamDataServiceservice.loadTeam(id);
            if (teamData == null) {
                return "redirect:/baseballteam";
            }

            String[] historyData = teamDataServiceservice.loadTeam(id).getHistory().split("↓");
            for (String data : historyData) {
                System.out.println(data);
            }
            System.out.println(historyData);
            model.addAttribute("teamData", teamData);
            model.addAttribute("historyData", historyData);

            return "teamdetailData";
        } catch (Exception e) {
            return "redirect:/baseballteam";

        }

    }

    /**
     * 
     * @param model modelに情報を詰めて返す
     * @return redirectで戻す事でURLをもとに戻すことができる
     */

    @GetMapping("/returnview")
    public String returnViewList() {

        return "redirect:/baseballteam";
    }

}
