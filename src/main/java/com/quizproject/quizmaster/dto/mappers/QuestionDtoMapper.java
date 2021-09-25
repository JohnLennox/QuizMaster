package com.quizproject.quizmaster.dto.mappers;

import com.quizproject.quizmaster.dto.QuestionDTO;
import com.quizproject.quizmaster.entities.Question;

public interface QuestionDtoMapper {
    QuestionDTO questionToDto(Question question);
}
