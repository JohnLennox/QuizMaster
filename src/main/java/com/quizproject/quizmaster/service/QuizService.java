package com.quizproject.quizmaster.service;

import com.quizproject.quizmaster.dto.QuizDTO;
import com.quizproject.quizmaster.dto.mappers.QuizDtoMapper;
import com.quizproject.quizmaster.exception.QuizNotFoundException;
import com.quizproject.quizmaster.repositories.QuizRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService{

    private final QuizRepository repository;

    private final QuizDtoMapper mapper;

    public QuizService(QuizDtoMapper mapper, QuizRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<QuizDTO> getAllQuizzes() {
        var quizzes =  repository.findAll();
        var quizDtos = new ArrayList<QuizDTO>();

        quizzes.forEach(quiz -> quizDtos.add(mapper.quizToDTO(quiz)));
        return quizDtos;
    }

    public ResponseEntity<QuizDTO> findById(Long id) {
        var quiz = repository.findById(id);
        if (quiz.isPresent()) {
            return new ResponseEntity<>(mapper.quizToDTO(quiz.get()), HttpStatus.OK);
        }
        throw new QuizNotFoundException(HttpStatus.NOT_FOUND, "Quiz with ID: ".concat(id.toString()).concat(" not found"), null);
    }
}
