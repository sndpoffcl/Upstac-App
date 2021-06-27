package com.upstac.TestLab.repository;

import com.upstac.TestLab.entity.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDO,Integer> {
    Optional<UserDO> findByEmailId(String emailId);
}
