package com.quizproject.quizmaster.repositories;

import com.quizproject.quizmaster.entities.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz, Long> {
}
