package com.gxs.springcloud.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class Study implements Serializable {
    private String username;
    private String password;
    private Long id;
}
