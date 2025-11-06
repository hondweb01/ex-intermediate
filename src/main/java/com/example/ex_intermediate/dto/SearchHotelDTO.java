package com.example.ex_intermediate.dto;

public class SearchHotelDTO {
private Integer id;
private String area_name;
private String hotel_name;
private String address;
private String  nearest_station;
private Integer   price;
private String  parking;

public Integer getId() {
    return id;
}
public void setId(Integer id) {
    this.id = id;
}
public String getArea_name() {
    return area_name;
}
public void setArea_name(String area_name) {
    this.area_name = area_name;
}
public String getHotel_name() {
    return hotel_name;
}
public void setHotel_name(String hotel_name) {
    this.hotel_name = hotel_name;
}
public String getAddress() {
    return address;
}
public void setAddress(String address) {
    this.address = address;
}
public String getNearest_station() {
    return nearest_station;
}
public void setNearest_station(String nearest_station) {
    this.nearest_station = nearest_station;
}
public Integer getPrice() {
    return price;
}
public void setPrice(Integer price) {
    this.price = price;
}
public String getParking() {
    return parking;
}
public void setParking(String parking) {
    this.parking = parking;
}


    
}
