package com.example.entity;

public class bus_stop {
    private int station_id;
    private String stop_name;
    private String qr_code_url;
    private double latitude;
    private double longitude;

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public String getStop_name() {
        return stop_name;
    }

    public void setStop_name(String description) {
        this.stop_name = description;
    }

    public String getQr_code_url() {
        return qr_code_url;
    }

    public void setQr_code_url(String qr_code_url) {
        this.qr_code_url = qr_code_url;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
