package com.kyhslam.myweb.repository;

import com.kyhslam.myweb.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
