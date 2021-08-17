package com.upstac.TestLab.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestBooking {
    private String trackingNo;
    private String testResult;
    private int bookingNo;
    private String status;
    private String testCode;
    private String testFeedBack;
    private boolean medicineReq;
}
