package com.upstac.TestLab.repository;

import com.upstac.TestLab.entity.TestDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<TestDO,Integer> {

    Optional<TestDO> findByName(String name);
    Optional<TestDO> findByTestCode(String testCode);

}
