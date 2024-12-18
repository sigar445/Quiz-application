package com.sigar.Quiz.App.service;

import com.sigar.Quiz.App.model.Question;
import com.sigar.Quiz.App.repo.QuestionsRepository;
import com.sigar.Quiz.App.sessions.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

import static com.sigar.Quiz.App.utils.Constants.CACHE_SIZE;

@Service
public class QuestionService {
    private QuestionsRepository questionsRepository;
    private Queue<Question> questionsCache; //TODO - This Would be a separate service
    @Autowired
    public QuestionService(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
        questionsCache = new ArrayBlockingQueue<>(CACHE_SIZE);
    }

    public Question getQuestionById(Long questionId){
        return questionsRepository.getReferenceById(questionId);
    }
    public void fillCache(Session session){
        Set<Long> askedQuestionIds = session.getAskedQuestionsIds();
        Pageable pageable = PageRequest.of(0, CACHE_SIZE);
        System.out.println("Asked questions are  ") ;
        askedQuestionIds.forEach(id -> System.out.printf(id + " "));
        System.out.println();
        Page<Question> page = questionsRepository.findRandomQuestions(askedQuestionIds, pageable);
        questionsCache.addAll(page.getContent());
    }

    public Question getRandomQuestion(Session session){
      if(questionsCache.isEmpty()) fillCache(session);
      Question newQuestion =  questionsCache.poll();
      session.updateAskedQuestions(newQuestion.getQuestionId());
      return newQuestion;
    }

}
