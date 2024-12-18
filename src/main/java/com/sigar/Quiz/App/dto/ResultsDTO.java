package com.sigar.Quiz.App.dto;

import com.sigar.Quiz.App.model.AnswerDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ResultsDTO {
    int correctAnswers;
    int wrongAnswers;
    List<AnswerDetails> answerDetails;
    public ResultsDTO(List<AnswerDetails> answerDetails) {
        this.answerDetails = answerDetails;
        correctAnswers = (int) answerDetails.stream().filter(AnswerDetails::isCorrect).count();
        wrongAnswers = answerDetails.size()-correctAnswers;
    }
}
