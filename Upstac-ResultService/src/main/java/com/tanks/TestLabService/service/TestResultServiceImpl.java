package com.tanks.TestLabService.service;

import com.tanks.TestLabService.entity.TestResultDO;
import com.tanks.TestLabService.exception.TestResultAlreadyExistsException;
import com.tanks.TestLabService.exception.TestResultNotFoundException;
import com.tanks.TestLabService.repository.TestResultRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestResultServiceImpl implements TestResultService{

    private static final Logger logger = LoggerFactory.getLogger(TestResultServiceImpl.class);

    @Autowired
    TestResultRepository testResultRepository;

    @Override
    public TestResultDO addTestResult(TestResultDO testResultDO) throws TestResultAlreadyExistsException {
        logger.debug("Entered addTestResult", testResultDO);
        if(testResultRepository.findByTrackingNo(testResultDO.getTrackingNo()).isEmpty()){
            return testResultRepository.save(testResultDO);
        }else{
            throw new TestResultAlreadyExistsException("Test results already exists with this tracking : " + testResultDO.getTrackingNo());
        }
    }

    @Override
    public TestResultDO updateTestResult(TestResultDO testResultDO) throws TestResultNotFoundException {
        logger.debug("Entered updateTestResult", testResultDO);
        Optional<TestResultDO> savedTestResult = testResultRepository.findByTrackingNo(testResultDO.getTrackingNo());
        if(savedTestResult.isEmpty()){
            throw new TestResultNotFoundException("Test results not found with this tracking : " + testResultDO.getTrackingNo());
        }else{
            TestResultDO existingTestResult = savedTestResult.get();
            existingTestResult.setTestResult(testResultDO.getTestResult());
            existingTestResult.setStatus(testResultDO.getStatus());
            return testResultRepository.save(existingTestResult);
        }
    }

    @Override
    public TestResultDO getTestResult(String trackingNo) throws TestResultNotFoundException{
        logger.debug("Entered getTestResult", trackingNo);
        Optional<TestResultDO> savedTestResult = testResultRepository.findByTrackingNo(trackingNo);
        if(savedTestResult.isEmpty()){
            throw new TestResultNotFoundException("Test results not found with this tracking : " + trackingNo);
        }else{
            return savedTestResult.get();
        }
    }

    @Override
    public TestResultDO getTestResult(int id) throws TestResultNotFoundException {
        logger.debug("Entered getTestResult", id);
        Optional<TestResultDO> savedTestResult = testResultRepository.findById(id);
        if(savedTestResult.isEmpty()){
            throw new TestResultNotFoundException("Test results not found with this id : " + id);
        }else{
            return savedTestResult.get();
        }
    }

    @Override
    public List<TestResultDO> getAllTestResults() {
        logger.debug("Entered getAllTestResults");
        return testResultRepository.findAll();
    }
}
