package com.quizproject.quizmaster.dto.mappers;

import com.quizproject.quizmaster.dto.QuizDTO;
import com.quizproject.quizmaster.entities.Quiz;

public class QuizDtoMapperImpl implements QuizDtoMapper{
    @Override
    public QuizDTO quizToDTO(Quiz quiz) {
        return QuizDTO.builder()
                .id(quiz.getId())
                .title(quiz.getTitle())
                .build();
    }
}
