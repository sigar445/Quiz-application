package com.sigar.Quiz.App.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionId;

    private String questionStatement;
    private List<String> options;
    private List<Integer> answersIds;

    public Question(String questionStatement, List<String> options, List<Integer> answersIds) {
        this.questionStatement = questionStatement;
        this.options = options;
        this.answersIds = answersIds;
    }


}
