package com.quizproject.quizmaster.controllers;

import com.quizproject.quizmaster.dto.AnswerDTO;
import com.quizproject.quizmaster.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping("/")
    public List<AnswerDTO> getAll(){
        return answerService.getAllAnswers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerDTO> findById(@PathVariable Long id){return answerService.findById(id);}
}
