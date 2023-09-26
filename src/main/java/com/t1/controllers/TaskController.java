package com.t1.controllers;

import com.t1.services.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Anna Ermachenkova
 */
@RestController
@Slf4j
@RequestMapping("/api")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping()
    public ResponseEntity<?> getFrequencyOfMeetingCharacters(@RequestParam(name = "string") String input) {
        if (input.isEmpty()) {
            log.info("Ошибка! На вход была подана пустая строка!");
            return new ResponseEntity<>("Ошибка! На вход была подана пустая строка!", HttpStatus.BAD_REQUEST);
        } else {
            log.info("Вычисляем частоту встречи символов в заданной строке");
            Map<Character, Integer> outputMap = taskService.getFrequencyOfMeetingCharacters(input);
            return new ResponseEntity<>(outputMap, HttpStatus.OK);
        }
    }
}