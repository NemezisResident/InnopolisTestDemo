package com.home.InnopolisTestDemo.services;

import com.home.InnopolisTestDemo.model.PollDto;
import com.home.InnopolisTestDemo.model.QuestionPollEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface GeneralServiceInf {

    List<PollDto> getFullPolls();

    Page<QuestionPollEntity> getFiltered(String nameOfPoll,
                                         Date activeDate,
                                         Boolean activity,
                                         Pageable pageable);

    PollDto saveFullPoll(PollDto dto);

    void deleteQuestionPollById(long id);
}