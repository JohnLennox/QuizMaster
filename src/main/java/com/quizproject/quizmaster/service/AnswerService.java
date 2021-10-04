package com.quizproject.quizmaster.service;

import com.quizproject.quizmaster.dto.AnswerDTO;
import com.quizproject.quizmaster.dto.mappers.AnswerDtoMapperImpl;
import com.quizproject.quizmaster.exception.AnswerException;
import com.quizproject.quizmaster.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    private final AnswerDtoMapperImpl mapper;

    public AnswerService(AnswerRepository answerRepository, AnswerDtoMapperImpl mapper) {
        this.answerRepository = answerRepository;
        this.mapper = mapper;
    }

    public List<AnswerDTO> getAllAnswers() {
        var answers = new ArrayList<AnswerDTO>();
        answerRepository.findAll().forEach(answer -> answers.add(mapper.answerToDto(answer)));
        return answers;
    }

    public ResponseEntity<AnswerDTO> findById(Long id) {
        var answer = answerRepository.findById(id);
        if(answer.isPresent()){
            return new ResponseEntity<>(mapper.answerToDto(answer.get()), HttpStatus.OK);
        }
        throw new AnswerException(HttpStatus.NOT_FOUND, "Answer with ID: ".concat(id.toString()).concat(" not found"), null);
    }
}
