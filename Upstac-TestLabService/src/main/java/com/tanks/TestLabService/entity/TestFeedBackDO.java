package com.tanks.TestLabService.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TEST_FEEDBACK")
public class TestFeedBackDO {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "feedback_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private int id;
    @Column(unique = true)
    private String trackingNo;
    @Column(unique = true)
    private int bookingNo;
    private String testFeedBack;
    private String testResult;
    private String status;
    private boolean medicineReq;
}
