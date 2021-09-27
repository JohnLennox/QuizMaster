package com.quizproject.quizmaster.controllers;

import com.quizproject.quizmaster.dto.AnswerDTO;
import com.quizproject.quizmaster.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping("/")
    public List<AnswerDTO> getAllAnswers(){
        return answerService.getAllAnswers();
    }
}
