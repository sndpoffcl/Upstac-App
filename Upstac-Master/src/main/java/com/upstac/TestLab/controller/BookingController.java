package com.upstac.TestLab.controller;

import com.upstac.TestLab.async.producer.MessageProducer;
import com.upstac.TestLab.entity.BookingDO;
import com.upstac.TestLab.model.Booking;
import com.upstac.TestLab.model.TestBooking;
import com.upstac.TestLab.service.BookingService;
import com.upstac.TestLab.utility.DTOEntityConverter;
import com.upstac.TestLab.utility.EntityDTOConverter;
import com.upstac.TestLab.utility.StringsUtil;
import com.upstac.TestLab.validator.BookingValidator;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {

    private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

    private final int SHORT_ID_LENGTH = 10;


    @Autowired
    BookingService bookingService;

    @Autowired
    DTOEntityConverter dtoEntityConverter;

    @Autowired
    EntityDTOConverter entityDTOConverter;

    @Autowired
    BookingValidator bookingValidator;

    @Autowired
    MessageProducer messageProducer;


    @GetMapping("/booking/{id}")
    public ResponseEntity getBookingDetails(@PathVariable("id") int id){
        logger.info("getBookingDetails : start", id);
        BookingDO savedBookingDO = bookingService.getBookingDetails(id);
        return ResponseEntity.ok(entityDTOConverter.convertBookingDOToBooking(savedBookingDO));
    }

    @PostMapping("/booking")
    public ResponseEntity acceptBookingDetails(@RequestBody Booking booking ){
        logger.info("acceptBookingDetails : start", booking);
        bookingValidator.validateBooking(booking);
        String trackingNo = RandomStringUtils.randomNumeric(SHORT_ID_LENGTH);
        booking.setTrackingNo(trackingNo);
        booking.setStatus(StringsUtil.BOOKED);
        BookingDO savedBookingDO = bookingService.acceptBookingDetails(dtoEntityConverter.convertBookingToBookingDO(booking));

        TestBooking newTestBooking = new TestBooking();
        newTestBooking.setBookingNo(savedBookingDO.getId());
        newTestBooking.setStatus(savedBookingDO.getStatus());
        newTestBooking.setTestCode(savedBookingDO.getTestDO().getTestCode());
        newTestBooking.setTrackingNo(savedBookingDO.getTrackingNo());
        messageProducer.send(newTestBooking);

        return ResponseEntity.ok(entityDTOConverter.convertBookingDOToBooking(savedBookingDO));
    }

    @PostMapping("/booking/{id}")
    public ResponseEntity updateBookingDetails(@RequestBody Booking booking, @PathVariable("id") int id ){
        logger.info("updateBookingDetails : start", booking);
        bookingValidator.validateBooking(booking);
        BookingDO savedBookingDO = bookingService.updateBookingDetails(id, dtoEntityConverter.convertBookingToBookingDO(booking));
        return ResponseEntity.ok(entityDTOConverter.convertBookingDOToBooking(savedBookingDO));
    }

}
