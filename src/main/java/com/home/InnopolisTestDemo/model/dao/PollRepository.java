package com.home.InnopolisTestDemo.model.dao;

import com.home.InnopolisTestDemo.model.PollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<PollEntity, Long> {
}