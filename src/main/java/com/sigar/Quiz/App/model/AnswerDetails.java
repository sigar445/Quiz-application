package com.sigar.Quiz.App.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AnswerDetails {
    private final Long questionId;
    private String remarks;
    private final boolean correct;
}
