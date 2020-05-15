package com.home.InnopolisTestDemo.configuration;

import com.home.InnopolisTestDemo.model.PollDto;
import com.home.InnopolisTestDemo.model.PollEntity;
import com.home.InnopolisTestDemo.model.QuestionPollEntity;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;


/**
 * Маппер
 */
class PollCustomMapper extends CustomMapper<PollDto, QuestionPollEntity> {
 
    @Override
    public void mapAtoB(PollDto source, QuestionPollEntity dest, MappingContext context) {
        dest.setId((source.getQuestionOfPollId()));
        dest.setPoll(new PollEntity(
                source.getPollId(),
                source.getNameOfPoll(),
                source.getStartDate(),
                source.getEndDate(),
                source.getActivity()));
    }
 
    @Override
    public void mapBtoA(QuestionPollEntity source, PollDto dest, MappingContext context) {
        dest.setQuestionOfPollId(source.getId());
        dest.setPollId(source.getPoll().getId());
        dest.setNameOfPoll(source.getPoll().getNameOfPoll());
        dest.setStartDate(source.getPoll().getStartDate());
        dest.setEndDate(source.getPoll().getEndDate());
        dest.setActivity(source.getPoll().getActivity());
    }
};