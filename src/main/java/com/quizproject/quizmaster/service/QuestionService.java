package com.quizproject.quizmaster.service;

import com.quizproject.quizmaster.dto.QuestionDTO;
import com.quizproject.quizmaster.dto.mappers.QuestionDtoMapperImpl;
import com.quizproject.quizmaster.exception.QuestionException;
import com.quizproject.quizmaster.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository repository;


    private final QuestionDtoMapperImpl mapper;

    public QuestionService(QuestionRepository repository, QuestionDtoMapperImpl mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<QuestionDTO> getAll() {
        var questions = new ArrayList<QuestionDTO>();
        repository.findAll().forEach(question -> questions.add(mapper.questionToDto(question)));
        return questions;
    }

    public ResponseEntity<QuestionDTO> findById(Long id) {
        var question = repository.findById(id);
        if(question.isPresent()){
            return new ResponseEntity<>(mapper.questionToDto(question.get()), HttpStatus.OK);
        }
        throw new QuestionException(HttpStatus.NOT_FOUND, "Question with ID: ".concat(id.toString()).concat(" not found"), null);
    }
}
