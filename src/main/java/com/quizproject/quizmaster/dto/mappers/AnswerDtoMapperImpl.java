package com.quizproject.quizmaster.dto.mappers;

import com.quizproject.quizmaster.dto.AnswerDTO;
import com.quizproject.quizmaster.entities.Answer;

public class AnswerDtoMapperImpl implements AnswerDtoMapper {
    @Override
    public AnswerDTO answerToDto(Answer answer) {
        return AnswerDTO.builder()
                .id(answer.getId())
                .answerText(answer.getAnswerText())
                .correct(answer.getCorrectAnswer())
                .questionRef(answer.getQuestion().getId())
                .build();
    }
}
