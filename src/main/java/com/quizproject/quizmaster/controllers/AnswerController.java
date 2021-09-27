package com.quizproject.quizmaster.controllers;

import com.quizproject.quizmaster.dto.AnswerDTO;
import com.quizproject.quizmaster.dto.mappers.AnswerDtoMapper;
import com.quizproject.quizmaster.dto.mappers.AnswerDtoMapperImpl;
import com.quizproject.quizmaster.entities.Answer;
import com.quizproject.quizmaster.repositories.AnswerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    private final AnswerRepository answerRepository;
    private final AnswerDtoMapper mapper;

    public AnswerController(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
        this.mapper = new AnswerDtoMapperImpl();
    }

    @GetMapping("/all")
    public List<AnswerDTO> getAllAnswers(){
        var answers = new ArrayList<AnswerDTO>();
        for (Answer answer: answerRepository.findAll()) {
            answers.add(mapper.answerToDto(answer));
        }
        return answers;
    }
}
