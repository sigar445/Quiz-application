package com.sigar.Quiz.App.sessions;

import com.sigar.Quiz.App.model.AnswerDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class Session {
    private Long sessionId;
    private Long userId;
    private Map<Long,AnswerDetails> results;
    private Set<Long> askedQuestionsIds;
    public void updateResults(AnswerDetails answerDetails){
        results.put(answerDetails.getQuestionId(),answerDetails);
    }
    public void updateAskedQuestions(Long questionId){
        askedQuestionsIds.add(questionId);
    }
    public List<AnswerDetails> getResults() {
        return Collections.unmodifiableList(new ArrayList<>(results.values()));
    }

}
