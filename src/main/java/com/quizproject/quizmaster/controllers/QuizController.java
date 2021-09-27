package com.quizproject.quizmaster.controllers;

import com.quizproject.quizmaster.dto.QuizDTO;
import com.quizproject.quizmaster.dto.mappers.QuizDtoMapper;
import com.quizproject.quizmaster.dto.mappers.QuizDtoMapperImpl;
import com.quizproject.quizmaster.entities.Quiz;
import com.quizproject.quizmaster.exception.QuizNotFoundException;
import com.quizproject.quizmaster.repositories.QuizRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final QuizRepository quizRepository;
    private final QuizDtoMapper mapper;

    public QuizController(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
        this.mapper = new QuizDtoMapperImpl();
    }

    @GetMapping("/all")
    public List<QuizDTO> getAll(){
        var quizzes = new ArrayList<QuizDTO>();
        for(Quiz quiz : quizRepository.findAll()){
            quizzes.add(mapper.quizToDTO(quiz));
        }
        return quizzes;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<QuizDTO> findById(@PathVariable Long id){
        var quiz = quizRepository.findById(id);
        if (quiz.isPresent()) {
            return new ResponseEntity<>(mapper.quizToDTO(quiz.get()), HttpStatus.OK);
        }
        throw new QuizNotFoundException(HttpStatus.NOT_FOUND, "Quiz with ID: " +id + " not found", null);
    }
}
