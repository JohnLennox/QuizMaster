package com.quizproject.quizmaster.dto.mappers;

import com.quizproject.quizmaster.dto.QuizDTO;
import com.quizproject.quizmaster.entities.Quiz;

public interface QuizDtoMapper {

    QuizDTO quizToDTO(Quiz quiz);

}
