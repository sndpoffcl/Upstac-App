package com.tanks.TestLabService.service;

import com.tanks.TestLabService.entity.TestFeedBackDO;
import com.tanks.TestLabService.exception.TestFeedBackAlreadyExistsException;
import com.tanks.TestLabService.exception.TestFeedbackNotFoundException;
import com.tanks.TestLabService.repository.TestFeedBackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestFeedBackServiceImpl implements TestFeedBackService {

    private static final Logger logger = LoggerFactory.getLogger(TestFeedBackServiceImpl.class);

    @Autowired
    TestFeedBackRepository testFeedBackRepository;

    @Override
    public TestFeedBackDO addTestFeedBack(TestFeedBackDO testFeedBackDO) throws TestFeedBackAlreadyExistsException {
        logger.debug("Entered addTestFeedBack", testFeedBackDO);
        if(testFeedBackRepository.findByTrackingNo(testFeedBackDO.getTrackingNo()).isEmpty()){
            return testFeedBackRepository.save(testFeedBackDO);
        }else{
            throw new TestFeedBackAlreadyExistsException("Test feedback already exists with this tracking : " + testFeedBackDO.getTrackingNo());
        }
    }

    @Override
    public TestFeedBackDO updateTestFeedback(TestFeedBackDO testFeedBackDO) throws TestFeedbackNotFoundException {
        logger.debug("Entered updateTestFeedback", testFeedBackDO);
        Optional<TestFeedBackDO> savedTestResult = testFeedBackRepository.findByTrackingNo(testFeedBackDO.getTrackingNo());
        if(savedTestResult.isEmpty()){
            throw new TestFeedbackNotFoundException("Test feedback not found with this tracking : " + testFeedBackDO.getTrackingNo());
        }else{
            TestFeedBackDO existingTestResult = savedTestResult.get();
            existingTestResult.setTestFeedBack(testFeedBackDO.getTestFeedBack());
            existingTestResult.setStatus(testFeedBackDO.getStatus());
            return testFeedBackRepository.save(existingTestResult);
        }
    }

    @Override
    public TestFeedBackDO getTestFeedback(String trackingNo) throws TestFeedbackNotFoundException {
        logger.debug("Entered getTestFeedback", trackingNo);
        Optional<TestFeedBackDO> savedTestResult = testFeedBackRepository.findByTrackingNo(trackingNo);
        if(savedTestResult.isEmpty()){
            throw new TestFeedbackNotFoundException("Test feedback not found with this tracking : " + trackingNo);
        }else{
            return savedTestResult.get();
        }
    }

    @Override
    public TestFeedBackDO getTestFeedback(int id) throws TestFeedbackNotFoundException {
        logger.debug("Entered getTestFeedback", id);
        Optional<TestFeedBackDO> savedTestResult = testFeedBackRepository.findById(id);
        if(savedTestResult.isEmpty()){
            throw new TestFeedbackNotFoundException("Test feedback not found with this id : " + id);
        }else{
            return savedTestResult.get();
        }
    }

    @Override
    public List<TestFeedBackDO> getAllTestFeedbacks() {
        logger.debug("Entered getAllTestFeedbacks");
        return testFeedBackRepository.findAll();
    }
}
