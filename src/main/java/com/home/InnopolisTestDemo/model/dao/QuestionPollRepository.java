package com.home.InnopolisTestDemo.model.dao;

import com.home.InnopolisTestDemo.model.QuestionPollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionPollRepository extends JpaRepository<QuestionPollEntity, Long> {
}