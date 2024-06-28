package com.yh.videoplayer.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.beans.Transient;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private String id;
    private int age;
    private String password;
//    @Transient
    private String token;
    // getter and setter
}
