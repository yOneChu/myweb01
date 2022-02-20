package com.kyhslam.myweb.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // 기본값 : AUTO
    private long id;

    @NotNull
    @Size(min = 2, max = 30, message = "제목은 2자리 이상 30자 이하 이다.")
    private String title;
    private String content;
}
