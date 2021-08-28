package com.tanks.TestLabService.repository;

import com.tanks.TestLabService.entity.TestFeedBackDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestFeedBackRepository extends JpaRepository<TestFeedBackDO,Integer> {
    Optional<TestFeedBackDO> findByTrackingNo(String trackingNo);
}
