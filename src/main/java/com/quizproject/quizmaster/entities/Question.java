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
    private Long id;

    private String questionText;

    @ManyToOne
    @JoinColumn(name ="quiz_id", nullable = false)
    private Quiz quiz;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

}
