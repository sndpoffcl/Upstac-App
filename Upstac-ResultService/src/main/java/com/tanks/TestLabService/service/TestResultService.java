package com.tanks.TestLabService.service;

import com.tanks.TestLabService.entity.TestResultDO;
import com.tanks.TestLabService.exception.TestResultAlreadyExistsException;
import com.tanks.TestLabService.exception.TestResultNotFoundException;

import java.util.List;

public interface TestResultService {
    public TestResultDO addTestResult(TestResultDO testResultDO) throws TestResultAlreadyExistsException;
    public TestResultDO updateTestResult(TestResultDO testResultDO) throws TestResultNotFoundException;
    public TestResultDO getTestResult(String trackingNo) throws TestResultNotFoundException;
    public TestResultDO getTestResult(int id) throws TestResultNotFoundException;
    public List<TestResultDO> getAllTestResults();

}
