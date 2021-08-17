package com.upstac.TestLab.utility;

import com.upstac.TestLab.entity.BookingDO;
import com.upstac.TestLab.entity.TestDO;
import com.upstac.TestLab.entity.UserDO;
import com.upstac.TestLab.model.Booking;
import com.upstac.TestLab.model.Test;
import com.upstac.TestLab.model.TestBooking;
import com.upstac.TestLab.model.User;
import com.upstac.TestLab.service.TestService;
import com.upstac.TestLab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DTOEntityConverter {

    @Autowired
    TestService testService;

    @Autowired
    UserService userService;

    public UserDO convertUserToUserDO(User user){
        UserDO userDO = new UserDO();
        userDO.setActive(user.isActive());
        userDO.setRoles(user.getRoles());
        userDO.setPassword(user.getPassword());
        userDO.setEmailId(user.getEmailId());
        userDO.setName(user.getName());
        userDO.setGender(user.getGender());
        userDO.setPhoneNumber(user.getPhoneNumber());
        userDO.setAddress(user.getAddress());

        return userDO;
    }

    public TestDO convertTestToTestDO(Test test){
        TestDO testDO = new TestDO();
        testDO.setImageURL(test.getImageURL());
        testDO.setPrice(test.getPrice());
        testDO.setAvailable(test.isAvailable());
        testDO.setName(test.getName());
        testDO.setTestCode(test.getTestCode());
        testDO.setDescription(test.getDescription());

        return testDO;
    }

    public BookingDO convertBookingToBookingDO(Booking booking){
        BookingDO bookingDO  = new BookingDO();
        bookingDO.setStatus(booking.getStatus());
        bookingDO.setCost(booking.getCost());
        bookingDO.setUserDO(userService.getUserDetails(booking.getCustomerId()));
        bookingDO.setTestDO(testService.getTestDetails(booking.getTestId()));
        bookingDO.setFeedBack(booking.getFeedBack());
        bookingDO.setTestResult(booking.getTestResult());
        bookingDO.setTrackingNo(booking.getTrackingNo());
        bookingDO.setMedicineReq(booking.isMedicineReq());

        return bookingDO;
    }

    public BookingDO convertTestBookingToBookingDO(TestBooking testBooking){
        BookingDO bookingDO  = new BookingDO();
        bookingDO.setStatus(testBooking.getStatus());
        bookingDO.setFeedBack(testBooking.getTestFeedBack());
        bookingDO.setTestResult(testBooking.getTestResult());
        bookingDO.setTrackingNo(testBooking.getTrackingNo());
        bookingDO.setMedicineReq(testBooking.isMedicineReq());
        return bookingDO;
    }


}
