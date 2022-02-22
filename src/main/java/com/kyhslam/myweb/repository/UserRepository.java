package com.kyhslam.myweb.repository;

import com.kyhslam.myweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
