package com.quizproject.quizmaster.controllers;

import com.quizproject.quizmaster.dto.QuestionDTO;
import com.quizproject.quizmaster.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {

    private final QuestionService service;

    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<QuestionDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
