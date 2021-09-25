package com.quizproject.quizmaster.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {

    @Nullable
    private Long id;

    @Nullable
    private String answerText;

    @Nullable
    private Boolean correct;

    @Nullable
    private Long questionRef;

}
