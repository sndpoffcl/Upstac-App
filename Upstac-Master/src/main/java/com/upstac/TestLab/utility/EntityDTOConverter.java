package com.upstac.TestLab.utility;

import com.upstac.TestLab.entity.BookingDO;
import com.upstac.TestLab.entity.TestDO;
import com.upstac.TestLab.entity.UserDO;
import com.upstac.TestLab.model.Booking;
import com.upstac.TestLab.model.Test;
import com.upstac.TestLab.model.User;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOConverter {

    public User convertUserDOToUser(UserDO userDO){
        User user = new User();
        user.setActive(userDO.isActive());
        user.setRoles(userDO.getRoles());
        user.setPassword(userDO.getPassword());
        user.setEmailId(userDO.getEmailId());
        user.setName(userDO.getName());
        user.setGender(userDO.getGender());
        user.setPhoneNumber(userDO.getPhoneNumber());
        user.setAddress(userDO.getAddress());
        user.setId(userDO.getId());
        return user;
    }

    public Test convertTestDOToTest(TestDO testDO){
        Test test = new Test();
        test.setImageURL(testDO.getImageURL());
        test.setPrice(testDO.getPrice());
        test.setAvailable(testDO.isAvailable());
        test.setName(testDO.getName());
        test.setTestCode(testDO.getTestCode());
        test.setDescription(testDO.getDescription());
        test.setId(testDO.getId());
        return test;
    }

    public Booking convertBookingDOToBooking(BookingDO bookingDO){
        Booking booking = new Booking();
        booking.setTestCode(bookingDO.getTestDO().getTestCode());
        booking.setTestName(bookingDO.getTestDO().getName());
        booking.setCost(bookingDO.getCost());
        booking.setFeedBack(bookingDO.getFeedBack());
        booking.setTestResult(bookingDO.getTrackingNo());
        booking.setTrackingNo(bookingDO.getTrackingNo());
        booking.setId(bookingDO.getId());
        return booking;

    }
}
