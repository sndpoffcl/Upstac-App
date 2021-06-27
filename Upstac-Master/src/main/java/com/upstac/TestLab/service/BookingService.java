package com.upstac.TestLab.service;

import com.upstac.TestLab.entity.BookingDO;
import com.upstac.TestLab.exception.BookingAlreadyExistsException;
import com.upstac.TestLab.exception.BookingDetailsNotFoundException;

import java.util.List;

public interface BookingService {
    public BookingDO acceptBookingDetails(BookingDO bookingDO) throws BookingAlreadyExistsException;
    public BookingDO getBookingDetails(int bookingId) throws BookingDetailsNotFoundException;
    public BookingDO getBookingDetails(String trackingNo) throws BookingDetailsNotFoundException;
    public List<BookingDO> findAllBookingDetails();
    public BookingDO updateBookingDetails(int bookingId, BookingDO bookingDO) throws BookingDetailsNotFoundException;
    public BookingDO updateBookingWithResultAndFeedback(BookingDO bookingDO) throws BookingDetailsNotFoundException;

}
