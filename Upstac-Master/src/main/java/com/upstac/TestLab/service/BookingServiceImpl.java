package com.upstac.TestLab.service;

import com.upstac.TestLab.entity.BookingDO;
import com.upstac.TestLab.exception.BookingAlreadyExistsException;
import com.upstac.TestLab.exception.BookingDetailsNotFoundException;
import com.upstac.TestLab.repository.BookingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{

    private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public BookingDO acceptBookingDetails(BookingDO bookingDO) throws BookingAlreadyExistsException {
        logger.debug("Entered acceptBookingDetails", bookingDO);
        if(bookingRepository.findById(bookingDO.getId()).isEmpty()){
            return bookingRepository.save(bookingDO);
        }else{
            throw new BookingAlreadyExistsException("Booking already exists with this code : " + bookingDO.getId());
        }
    }

    @Override
    public BookingDO getBookingDetails(int bookingId) throws BookingDetailsNotFoundException {
        logger.debug("Entered getBookingDetails", bookingId);
        Optional<BookingDO> savedBookingDO = bookingRepository.findById(bookingId);
        if(savedBookingDO.isEmpty()){
            throw new BookingDetailsNotFoundException("Booking details not found : " + bookingId);
        }else{
            return savedBookingDO.get();
        }
    }

    @Override
    public BookingDO getBookingDetails(String trackingNo) throws BookingDetailsNotFoundException {
        logger.debug("Entered getBookingDetails", trackingNo);
        Optional<BookingDO> savedBookingDO = bookingRepository.findByTrackingNo(trackingNo);
        if(savedBookingDO.isEmpty()){
            throw new BookingDetailsNotFoundException("Booking details not found : " + trackingNo);
        }else{
            return savedBookingDO.get();
        }
    }

    @Override
    public List<BookingDO> findAllBookingDetails() {
        return bookingRepository.findAll();
    }

    @Override
    public BookingDO updateBookingDetails(int bookingId, BookingDO bookingDO) throws BookingDetailsNotFoundException {
        BookingDO initialBooking = getBookingDetails(bookingId);
        initialBooking.setStatus(bookingDO.getStatus());
        bookingRepository.save(initialBooking);
        return initialBooking;
    }

    @Override
    public BookingDO updateBookingWithResultAndFeedback(BookingDO bookingDO) throws BookingDetailsNotFoundException {
        BookingDO initialBooking = getBookingDetails(bookingDO.getTrackingNo());
        initialBooking.setStatus(bookingDO.getStatus());
        initialBooking.setFeedBack(bookingDO.getFeedBack());
        initialBooking.setTestResult(bookingDO.getTestResult());
        bookingRepository.save(initialBooking);
        return initialBooking;
    }
}
