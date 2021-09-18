package com.quizproject.quizmaster.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Represents a Question in a Quiz
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String questionText;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "question_id")
    private List<Answer> answers;

}
