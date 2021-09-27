package com.quizproject.quizmaster.controllers;

import com.quizproject.quizmaster.dto.QuestionDTO;
import com.quizproject.quizmaster.dto.mappers.QuestionDtoMapper;
import com.quizproject.quizmaster.dto.mappers.QuestionDtoMapperImpl;
import com.quizproject.quizmaster.entities.Question;
import com.quizproject.quizmaster.repositories.QuestionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private final QuestionDtoMapper mapper;
    private final QuestionRepository questionRepository;

    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
        this.mapper = new QuestionDtoMapperImpl();
    }

    @GetMapping("/all" )
    public List<QuestionDTO> getAllQuestions(){
        var questions = new ArrayList<QuestionDTO>();
        for(Question question : questionRepository.findAll()){
            questions.add(mapper.questionToDto(question));
        }
        return questions;
    }
}
