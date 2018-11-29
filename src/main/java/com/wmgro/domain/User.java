package com.wmgro.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="t_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phone;
    private String password;
    private String nick_name;
    private String sex;
    private String email;
    private String create_time;
}
