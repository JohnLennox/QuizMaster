package com.quizproject.quizmaster.dto.mappers;

import com.quizproject.quizmaster.dto.QuestionDTO;
import com.quizproject.quizmaster.entities.Question;

public class QuestionDtoMapperImpl implements QuestionDtoMapper{
    public QuestionDTO questionToDto(Question question){
        return QuestionDTO.builder()
                .id(question.getId())
                .questionText(question.getQuestionText())
                .quizRef(question.getQuiz().getId())
                .build();
    }
}
