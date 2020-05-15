package com.home.InnopolisTestDemo.controllers;

import com.home.InnopolisTestDemo.model.PollDto;
import com.home.InnopolisTestDemo.model.QuestionPollEntity;
import com.home.InnopolisTestDemo.services.GeneralService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Главный контроллер
 */
@RestController
public class PollController {

    @Autowired
    private GeneralService service;

    @ApiOperation(value = "Получить все опросы")
    @GetMapping("/polls")
    public ResponseEntity<List<PollDto>> getFullPolls() {
        return ResponseEntity.ok(service.getFullPolls());
    }

    @ApiOperation(value = "Добавить опрос")
    @PutMapping("/polls")
    public ResponseEntity<PollDto> saveFullPoll(@RequestBody PollDto dto) {
        return ResponseEntity.ok(service.saveFullPoll(dto));
    }

    @ApiOperation(value = "Удалить опрос")
    @DeleteMapping("/polls/{id}")
    public ResponseEntity deleteQuestionPoll(@PathVariable Long id) {
        service.deleteQuestionPollById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Получить опросы по условиям фильтра")
    @GetMapping("/filtered/polls")
    public ResponseEntity<Page<QuestionPollEntity>> getFilteredPolls(
            @RequestParam("nameOfPoll") String nameOfPoll,
            @RequestParam("activeDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date activeDate,
            @RequestParam("activity") Boolean activity,
            Pageable pageable) {
        return ResponseEntity.ok(service.getFiltered(nameOfPoll, activeDate, activity, pageable));
    }
}
