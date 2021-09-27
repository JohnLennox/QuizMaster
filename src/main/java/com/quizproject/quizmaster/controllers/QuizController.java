package com.quizproject.quizmaster.controllers;

import com.quizproject.quizmaster.dto.QuizDTO;
import com.quizproject.quizmaster.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {

    @Autowired
    private QuizService service;

    @GetMapping("/")
    public List<QuizDTO> getAll(){
        return service.getAllQuizzes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDTO> findById(@PathVariable Long id){
        return service.findById(id);
    }
}
