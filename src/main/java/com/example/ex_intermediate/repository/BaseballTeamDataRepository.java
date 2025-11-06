package com.example.ex_intermediate.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.ex_intermediate.dto.TeamDTO;

@Repository
public class BaseballTeamDataRepository {

    @Autowired
    NamedParameterJdbcTemplate template;
    private static final RowMapper<TeamDTO> TEAM_ROW_MAPPER = (rs, i) -> {
        TeamDTO team = new TeamDTO();
        team.setId(rs.getInt("id"));
        team.setLeague_name(rs.getString("league_name"));
        team.setTeam_name(rs.getString("team_name"));
        team.setInauguration(rs.getString("inauguration"));
        team.setHistory(rs.getString("history"));
        team.setHeadquarters(rs.getString("headquarters"));
        return team;

    };

    /**
     * @param teamData チームデータ
     * @return チームリスト
     * 発足日順
     */
    public List<TeamDTO> TeamList() {
        String sql = "select *from teams order by inauguration asc";

        List<TeamDTO> teamData = template.query(sql, TEAM_ROW_MAPPER);
        return teamData;
    }

    /**
     * @param teamDataById id絞りのチームデータ
     *
     * 
     */

    public TeamDTO loadTeam(Integer id) {
        String sql = "select *from teams where id=:id  order by inauguration asc";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        TeamDTO teamDataById = template.queryForObject(sql, param, TEAM_ROW_MAPPER);
        return teamDataById;
    }

}
