package com.quizproject.quizmaster.repositories;

import com.quizproject.quizmaster.entities.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
}
