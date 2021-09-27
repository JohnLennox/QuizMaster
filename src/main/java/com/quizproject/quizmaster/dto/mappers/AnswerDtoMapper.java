package com.quizproject.quizmaster.dto.mappers;

import com.quizproject.quizmaster.dto.AnswerDTO;
import com.quizproject.quizmaster.entities.Answer;

public interface AnswerDtoMapper {
    AnswerDTO answerToDto(Answer answer);
}
