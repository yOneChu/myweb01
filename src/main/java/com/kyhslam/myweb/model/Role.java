package com.kyhslam.myweb.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // 권한이름

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
