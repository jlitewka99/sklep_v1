package com.model;

public class Address
{
private int apartament_nr;
private String home_nr;
private String streat;
private String place;
private  int zip_code;

    public Address(int apartament_nr, String home_nr, String streat, String place, int zip_code) {
        this.apartament_nr = apartament_nr;
        this.home_nr = home_nr;
        this.streat = streat;
        this.place = place;
        this.zip_code = zip_code;
    }

    public int getApartament_nr() {
        return apartament_nr;
    }

    public String getHome_nr() {
        return home_nr;
    }

    public String getStreat() {
        return streat;
    }

    public String getPlace() {
        return place;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setApartament_nr(int apartament_nr) {
        this.apartament_nr = apartament_nr;
    }

    public void setHome_nr(String home_nr) {
        this.home_nr = home_nr;
    }

    public void setStreat(String streat) {
        this.streat = streat;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

}
