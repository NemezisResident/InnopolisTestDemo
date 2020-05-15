package com.home.InnopolisTestDemo.services;

import com.home.InnopolisTestDemo.model.PollDto;
import com.home.InnopolisTestDemo.model.QuestionPollEntity;
import com.home.InnopolisTestDemo.model.dao.PollRepository;
import com.home.InnopolisTestDemo.model.dao.QuestionPollRepository;
import com.home.InnopolisTestDemo.model.dao.QuestionPollSpecs;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Service
 */
@Service
public class GeneralService implements GeneralServiceInf {

    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private QuestionPollRepository questionPollRepository;

    @Autowired
    private MapperFacade mapperFacade;

    @Override
    @Transactional(readOnly = true)
    public Page<QuestionPollEntity> getFiltered(String nameOfPoll,
                                                Date activeDate,
                                                Boolean activity,
                                                Pageable pageable) {

        return questionPollRepository.findAll(
                QuestionPollSpecs.getByFilterParams(nameOfPoll, activeDate, activity),
                pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public List<PollDto> getFullPolls() {
        return mapperFacade.mapAsList(questionPollRepository.findAll(),PollDto.class);
    }

    @Override
    @Transactional
    public PollDto saveFullPoll(PollDto dto) {
        QuestionPollEntity entity = mapperFacade.map(dto, QuestionPollEntity.class);
        return mapperFacade.map(questionPollRepository.save(entity), PollDto.class);
    }

    @Override
    @Transactional
    public void deleteQuestionPollById(long id) {
        questionPollRepository.deleteById(id);
    }
}
