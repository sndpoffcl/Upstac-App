package com.upstac.TestLab.validator;

import com.upstac.TestLab.exception.APIException;
import com.upstac.TestLab.model.Test;
import com.upstac.TestLab.utility.StringsUtil;
import org.springframework.stereotype.Component;

@Component
public class TestValidatorImpl implements TestValidator{

    @Override
    public void validateTest(Test test) {
        if(StringsUtil.isEmptyOrNull(test.getName())){
            throw new APIException("Invalid test name");
        }
        if(StringsUtil.isEmptyOrNull(test.getTestCode())){
            throw new APIException("Invalid test code");
        }
        if(StringsUtil.isEmptyOrNull(test.getDescription())){
            throw new APIException("Invalid test description");
        }
        if(test.getPrice() <= 0 ){
            throw new APIException("Invalid test price");
        }
        if(!test.isAvailable()){
            throw new APIException("Test Not Available");
        }
    }
}
