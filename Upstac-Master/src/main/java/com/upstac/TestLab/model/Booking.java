package com.upstac.TestLab.model;

import lombok.Data;

@Data
public class Booking {
    private int id;
    private String trackingNo;
    private int cost;
    private String testName;
    private String testResult;
    private String feedBack;
    private String testCode;
    private String status;
    private int customerId;
    private int testId;
    private boolean medicineReq;

    public Booking(String trackingNo, int cost, String testName, String testResult, String feedBack, String testCode, String status, int customerId, int testId) {
        this.trackingNo = trackingNo;
        this.cost = cost;
        this.testName = testName;
        this.testResult = testResult;
        this.feedBack = feedBack;
        this.testCode = testCode;
        this.status = status;
        this.customerId = customerId;
        this.testId = testId;
    }

    public Booking(int id, String trackingNo, int cost, String testName, String testResult, String feedBack, String testCode, String status, int customerId, int testId, boolean medicineReq) {
        this.id = id;
        this.trackingNo = trackingNo;
        this.cost = cost;
        this.testName = testName;
        this.testResult = testResult;
        this.feedBack = feedBack;
        this.testCode = testCode;
        this.status = status;
        this.customerId = customerId;
        this.testId = testId;
        this.medicineReq = medicineReq;
    }

    public Booking() {
    }


}
