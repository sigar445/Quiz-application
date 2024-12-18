package com.sigar.Quiz.App.service;

import com.sigar.Quiz.App.model.AnswerDetails;
import com.sigar.Quiz.App.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerValidator {
    public static AnswerDetails validateAnswer(Question question, List<Integer> userResponses) {
        List<Integer> correctAnswers = question.getAnswersIds();
        boolean isCorrect = userResponses.size() == correctAnswers.size() &&
                userResponses.containsAll(correctAnswers);

        String remarks = buildRemarks(question, isCorrect);

        return new AnswerDetails(question.getQuestionId(), remarks, isCorrect);
    }

    private static String buildRemarks(Question question, boolean isCorrect) {
        StringBuilder remarks = new StringBuilder();
        if(isCorrect)
            remarks.append("You have answered correctly. ");
        else
            remarks.append("You have answered wrongly. ");
        remarks.append("Correct answers are: ");
        question.getAnswersIds()
                .forEach(answerId -> remarks.append(question.getOptions().get(answerId) + " "));
        return remarks.toString();
    }
}

