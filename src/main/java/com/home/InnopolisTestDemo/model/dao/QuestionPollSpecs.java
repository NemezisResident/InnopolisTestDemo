package com.home.InnopolisTestDemo.model.dao;

import com.home.InnopolisTestDemo.model.PollEntity;
import com.home.InnopolisTestDemo.model.PollEntity_;
import com.home.InnopolisTestDemo.model.QuestionPollEntity;
import com.home.InnopolisTestDemo.model.QuestionPollEntity_;
import liquibase.util.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * Спецификации для фильтрации сущностей
 */
public class QuestionPollSpecs {

    public static Specification<QuestionPollEntity> getByFilterParams(String name, Date date, Boolean activity) {
        return (root, query, cb) ->{

            ArrayList<Predicate> predicates = new ArrayList<>();
            Join<QuestionPollEntity, PollEntity> modelJoin = root.join(QuestionPollEntity_.poll);

            if (StringUtils.isNotEmpty(name)) {
                predicates.add(cb.equal(modelJoin.get(PollEntity_.NAME_OF_POLL), name));
            }

            if (Objects.nonNull(activity)){
                predicates.add(cb.equal(modelJoin.get(PollEntity_.activity),activity));
            }

            if (Objects.nonNull(date)){
                predicates.add(cb.between(cb.literal(date),
                        modelJoin.get(PollEntity_.START_DATE),
                        modelJoin.get(PollEntity_.END_DATE)));
            }

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}