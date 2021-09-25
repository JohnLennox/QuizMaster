package com.quizproject.quizmaster.controllers;

import com.quizproject.quizmaster.dto.QuizDTO;
import com.quizproject.quizmaster.dto.mappers.QuizDtoMapper;
import com.quizproject.quizmaster.dto.mappers.QuizDtoMapperImpl;
import com.quizproject.quizmaster.entities.Quiz;
import com.quizproject.quizmaster.repositories.QuizRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuizController {
    public static final String BASE = "/quiz";
    private final QuizRepository quizRepository;
    private QuizDtoMapper mapper;

    public QuizController(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
        this.mapper = new QuizDtoMapperImpl();
    }

    @GetMapping(BASE + "/all")
    List<QuizDTO> getAll(){
        var quizzes = new ArrayList<QuizDTO>();
        for(Quiz quiz : quizRepository.findAll()){
            quizzes.add(mapper.quizToDTO(quiz));
        }
        return quizzes;
    }
}
