package com.upstac.TestLab.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "BOOKING")
public class BookingDO extends BaseDO{
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "booking_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1000"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private int id;
    @Column(unique = true)
    private String trackingNo;
    private int cost;
    private String testResult;
    private String feedBack;
    private String status;

    @ManyToOne
    @JsonBackReference("user_booking")
    private UserDO userDO;

    @OneToOne
    private TestDO testDO;

}
