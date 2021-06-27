package com.upstac.TestLab.service;

import com.upstac.TestLab.entity.TestDO;
import com.upstac.TestLab.exception.TestAlreadyExistsException;
import com.upstac.TestLab.exception.TestDetailsNotFoundException;

import java.util.List;

public interface TestService {
    public TestDO acceptTestDetails(TestDO testDO) throws TestAlreadyExistsException;
    public TestDO getTestDetails(String testCode) throws TestDetailsNotFoundException;
    public TestDO getTestDetails(int testId) throws TestDetailsNotFoundException;
    public List<TestDO> findAllTestDetails();
    public TestDO updateTestDetails(int testId, TestDO testDO) throws TestDetailsNotFoundException;
    public void addInitialTests();
}
