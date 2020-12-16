package com.example.freindlist.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {




     @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Long phone;
    private String name;
    private String email;


    public User()
    {

    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public User(Integer id, Long phone, String name, String email) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.email = email;
    }


}
