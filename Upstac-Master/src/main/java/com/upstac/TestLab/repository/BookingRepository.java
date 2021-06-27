package com.upstac.TestLab.repository;

import com.upstac.TestLab.entity.BookingDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<BookingDO, Integer> {

    Optional<BookingDO> findByTrackingNo(String trackingNo);
}
