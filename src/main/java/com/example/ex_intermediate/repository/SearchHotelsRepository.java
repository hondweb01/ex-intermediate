package com.example.ex_intermediate.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.ex_intermediate.dto.SearchHotelDTO;
@Repository
public class SearchHotelsRepository {
 @Autowired
    NamedParameterJdbcTemplate template;
    private static final RowMapper<SearchHotelDTO> HOTELS_ROW_MAPPER = (rs, i) -> {
        SearchHotelDTO hotel = new SearchHotelDTO();
        hotel.setId(rs.getInt("id"));
        hotel.setHotel_name(rs.getString("hotel_name"));
        hotel.setAddress(rs.getString("address"));
        hotel.setNearest_station(rs.getString("nearest_station"));
        hotel.setParking(rs.getString("parking"));
        hotel.setPrice(rs.getInt("price"));
        return hotel;

    };

    /**
     * @param teamData チームデータ
     * @return チームリスト
     * 発足日順
     */
    public List<SearchHotelDTO> selectPriceHotelList(Integer price) {
        String sql = "select *from hotels where price<=:price;";
        SqlParameterSource param=new MapSqlParameterSource().addValue("price", price);
     List<SearchHotelDTO>  hotelList = template.query(sql,param,HOTELS_ROW_MAPPER);
        return hotelList;
    }
    public List<SearchHotelDTO> findAllHotelList() {
        String sql = "select *from hotels;";
   
     List<SearchHotelDTO>  findAllhotelList = template.query(sql,HOTELS_ROW_MAPPER);
        return findAllhotelList;
    }
    
}
