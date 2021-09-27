package com.quizproject.quizmaster.service;

import com.quizproject.quizmaster.dto.AnswerDTO;
import com.quizproject.quizmaster.dto.mappers.AnswerDtoMapper;
import com.quizproject.quizmaster.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private AnswerDtoMapper mapper;

    public List<AnswerDTO> getAllAnswers() {
        var answers = new ArrayList<AnswerDTO>();
        answerRepository.findAll().forEach(answer -> answers.add(mapper.answerToDto(answer)));
        return answers;
    }
}
