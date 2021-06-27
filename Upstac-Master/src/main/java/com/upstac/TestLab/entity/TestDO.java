package com.upstac.TestLab.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TEST")
public class TestDO extends BaseDO{
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "test_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private int id;
    private String name;
    @Column(unique = true)
    private String testCode;
    private int price;
    private String imageURL;
    private String description;
    private boolean isAvailable;

    public TestDO(int id, String name,String testCode, int price, String imageURL, boolean isAvailable, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageURL = imageURL;
        this.isAvailable = isAvailable;
        this.testCode = testCode;
        this.description = description;
    }

    public TestDO(String name,String testCode, int price, String imageURL, boolean isAvailable, String description) {
        this.name = name;
        this.price = price;
        this.imageURL = imageURL;
        this.isAvailable = isAvailable;
        this.testCode = testCode;
        this.description = description;
    }

    public TestDO() {
    }

}
