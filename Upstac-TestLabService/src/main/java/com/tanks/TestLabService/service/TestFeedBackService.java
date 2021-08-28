package com.tanks.TestLabService.service;

import com.tanks.TestLabService.entity.TestFeedBackDO;
import com.tanks.TestLabService.exception.TestFeedBackAlreadyExistsException;
import com.tanks.TestLabService.exception.TestFeedbackNotFoundException;

import java.util.List;

public interface TestFeedBackService {
    public TestFeedBackDO addTestFeedBack(TestFeedBackDO testFeedBackDO) throws TestFeedBackAlreadyExistsException;
    public TestFeedBackDO updateTestFeedback(TestFeedBackDO testFeedBackDO) throws TestFeedbackNotFoundException;
    public TestFeedBackDO getTestFeedback(String trackingNo) throws TestFeedbackNotFoundException;
    public TestFeedBackDO getTestFeedback(int id) throws TestFeedbackNotFoundException;
    public List<TestFeedBackDO> getAllTestFeedbacks();

}
