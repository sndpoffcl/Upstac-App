package com.upstac.TestLab.controller;

import com.upstac.TestLab.entity.TestDO;
import com.upstac.TestLab.model.Test;
import com.upstac.TestLab.service.TestService;
import com.upstac.TestLab.utility.DTOEntityConverter;
import com.upstac.TestLab.utility.EntityDTOConverter;
import com.upstac.TestLab.validator.TestValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    TestService testService;

    @Autowired
    DTOEntityConverter dtoEntityConverter;

    @Autowired
    EntityDTOConverter entityDTOConverter;

    @Autowired
    TestValidator testValidator;

    @Autowired

//    @GetMapping("/test/{testCode}")
//    public ResponseEntity getTestDetails(@PathVariable("testCode") String testCode){
//        logger.info("GetTestDetails : start", testCode);
//        TestDO savedTestDO = testService.getTestDetails(testCode);
//        return ResponseEntity.ok(entityDTOConverter.convertTestDOToTest(savedTestDO));
//    }

    @GetMapping("/test")
    public ResponseEntity getAllTestDetails(){
        logger.info("getAllTestDetails : start");
        List<TestDO> savedTestDOs = testService.findAllTestDetails();
        List<Test> savedTest = new ArrayList<>();
        for(TestDO t : savedTestDOs) {
            savedTest.add(entityDTOConverter.convertTestDOToTest(t));
        }
        return ResponseEntity.ok(savedTest);
    }

    @GetMapping("/test/{id}")
    public ResponseEntity getTestDetails(@PathVariable("id") int id){
        logger.info("GetTestDetails : start", id);
        TestDO savedTestDO = testService.getTestDetails(id);
        return ResponseEntity.ok(entityDTOConverter.convertTestDOToTest(savedTestDO));
    }

    @PostMapping("/test")
    public ResponseEntity acceptTestDetails(@RequestBody Test test){
        logger.info("acceptTestDetails : start", test.toString());
        testValidator.validateTest(test);
        TestDO savedTestDO = testService.acceptTestDetails(dtoEntityConverter.convertTestToTestDO(test));
        return ResponseEntity.ok(entityDTOConverter.convertTestDOToTest(savedTestDO));
    }

    @PutMapping("/test/{id}")
    public ResponseEntity updateTestDetails(@RequestBody Test test, @PathVariable("id") int testId){
        logger.info("updateTestDetails : start", test.toString());
        testValidator.validateTest(test);
        TestDO savedTestDO = testService.updateTestDetails(testId, dtoEntityConverter.convertTestToTestDO(test));
        return ResponseEntity.ok(entityDTOConverter.convertTestDOToTest(savedTestDO));
    }
}

