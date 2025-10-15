package com.example.demo.user.entity;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String username;
    private String id;
    private String password;
}
