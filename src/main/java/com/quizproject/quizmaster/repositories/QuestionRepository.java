package com.quizproject.quizmaster.repositories;

import com.quizproject.quizmaster.entities.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository <Question,Long> {
}
