package com.example.freindlist.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Graph {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
   
    private Integer src;
    private Integer dest;




    public Graph()
    {

    }

    //Constructor

    public Graph(Integer src, Integer dest) {
        this.src = src;
        this.dest = dest;
    }



    //Getter and Setter

    public Integer getId() {
        return id;
    }


    public Integer getSrc() {
        return src;
    }

    public void setSrc(Integer src) {
        this.src = src;
    }

    public Integer getDest() {
        return dest;
    }

    public void setDest(Integer dest) {
        this.dest = dest;
    }



}





