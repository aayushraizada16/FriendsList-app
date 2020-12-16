package com.example.freindlist.dto;

public class ResponseDTO {


    private String status;
    private Integer id;

    public ResponseDTO() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public ResponseDTO(String status, Integer id) {
        this.status = status;
        this.id = id;
    }
}
