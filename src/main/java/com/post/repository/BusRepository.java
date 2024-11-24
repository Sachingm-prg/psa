package com.post.repository;

import com.post.Entity.Bus;
import com.post.Entity.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
}