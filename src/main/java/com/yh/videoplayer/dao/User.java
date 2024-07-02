package com.yh.videoplayer.dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String username;
    private String id;
    private int age;
    private String password;
//    @Transient
    private String token;
    // getter and setter
}
