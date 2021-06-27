package com.tanks.TestLabService.repository;

import com.tanks.TestLabService.entity.TestResultDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestResultRepository extends JpaRepository<TestResultDO,Integer> {
    Optional<TestResultDO> findByTrackingNo(String trackingNo);
}
