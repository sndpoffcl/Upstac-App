package com.upstac.TestLab.service;

import com.upstac.TestLab.entity.TestDO;
import com.upstac.TestLab.exception.TestAlreadyExistsException;
import com.upstac.TestLab.exception.TestDetailsNotFoundException;
import com.upstac.TestLab.repository.TestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImpl implements TestService{

    private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

    @Autowired
    TestRepository testRepository;

    @Override
    public TestDO acceptTestDetails(TestDO testDO) throws TestAlreadyExistsException{
        logger.debug("Entered acceptTestDetails", testDO);
        if(testRepository.findByTestCode(testDO.getTestCode()).isEmpty()){
            return testRepository.save(testDO);
        }else{
            throw new TestAlreadyExistsException("Test already exists with this test code : " + testDO.getTestCode());
        }
    }

    @Override
    public TestDO getTestDetails(String testCode) throws TestDetailsNotFoundException{
        logger.debug("Entered getTestDetails", testCode);
        Optional<TestDO> savedTestDO = testRepository.findByTestCode(testCode);
        if(savedTestDO.isEmpty()){
            throw new TestDetailsNotFoundException("Test details not found : " + testCode);
        }else{
            return savedTestDO.get();
        }
    }

    @Override
    public TestDO getTestDetails(int testId) throws TestDetailsNotFoundException {
        logger.debug("Entered getTestDetails", testId);
        Optional<TestDO> savedTestDO = testRepository.findById(testId);
        if(savedTestDO.isEmpty()){
            throw new TestDetailsNotFoundException("Test details not found : " + testId);
        }else{
            return savedTestDO.get();
        }
    }

    @Override
    public List<TestDO> findAllTestDetails() {
        return testRepository.findAll();
    }

    @Override
    public TestDO updateTestDetails(int testId, TestDO testDO) throws TestDetailsNotFoundException{
        TestDO initialTest = getTestDetails(testId);
        logger.info("Initial Test details : " + initialTest.toString());
        initialTest.setName(testDO.getName());
        initialTest.setAvailable(testDO.isAvailable());
        initialTest.setPrice(testDO.getPrice());
        initialTest.setImageURL(testDO.getImageURL());
        testRepository.save(initialTest);
        return initialTest;
    }

    public void addInitialTests(){
        TestDO bloodCountTest = new TestDO("Total Blood Count Test", "TBC01", 500, "NA", true, "Computes total blood count, empty stomach");
        testRepository.save(bloodCountTest);
        TestDO liverFunctionTest = new TestDO("Liver Function Test", "LFT01", 1200, "NA", true, "Computes live function serums, empty stomach");
        testRepository.save(liverFunctionTest);
        TestDO lipidProfileTest = new TestDO("Lipid Profile Test", "LP01", 1200, "NA", true, "Computer cholestrol, empty stomach");
        testRepository.save(lipidProfileTest);
        TestDO bloodSugarLevel = new TestDO("blood Sugar Test", "BS01", 500, "NA", true, "Empty stomach is must for proper blood sugar check");
        testRepository.save(bloodSugarLevel);
    }
}
