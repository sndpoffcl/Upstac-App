package com.upstac.TestLab.model;

import lombok.Data;

@Data
public class Test {
    private int id;
    private String name;
    private int price;
    private String imageURL;
    private boolean isAvailable;
    private String testCode;
    private String description;
}
