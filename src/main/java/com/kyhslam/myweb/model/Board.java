package com.kyhslam.myweb.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // 기본값 : AUTO
    private long id;


    private String title;
    private String content;

}
