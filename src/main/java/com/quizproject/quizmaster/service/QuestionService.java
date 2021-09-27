package com.quizproject.quizmaster.service;

import com.quizproject.quizmaster.dto.QuestionDTO;
import com.quizproject.quizmaster.dto.mappers.QuestionDtoMapperImpl;
import com.quizproject.quizmaster.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository repository;

    @Autowired
    private QuestionDtoMapperImpl mapper;

    public List<QuestionDTO> getAll() {
        var questions = new ArrayList<QuestionDTO>();
        repository.findAll().forEach(question -> questions.add(mapper.questionToDto(question)));
        return questions;
    }
}
