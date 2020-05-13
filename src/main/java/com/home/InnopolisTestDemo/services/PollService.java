package com.home.InnopolisTestDemo.services;

import com.home.InnopolisTestDemo.model.PollEntity;
import com.home.InnopolisTestDemo.model.dao.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service
 */
@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;

    public List<PollEntity> getPolls(){
        return pollRepository.findAll();
    }
}
