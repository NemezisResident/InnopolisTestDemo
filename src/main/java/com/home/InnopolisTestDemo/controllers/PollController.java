package com.home.InnopolisTestDemo.controllers;

import com.home.InnopolisTestDemo.model.PollEntity;
import com.home.InnopolisTestDemo.services.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Главный контроллер
 */
@RestController
public class PollController {

    @Autowired
    private PollService pollService;

    @GetMapping("/polls")
    public List<PollEntity> getDocuments() {
        return pollService.getPolls();
    }

    @GetMapping("/test")
    public String get() {
        return "Hellow world";
    }
}
