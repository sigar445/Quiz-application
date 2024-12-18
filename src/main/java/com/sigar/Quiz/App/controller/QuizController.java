package com.sigar.Quiz.App.controller;


import com.sigar.Quiz.App.dto.*;
import com.sigar.Quiz.App.model.AnswerDetails;
import com.sigar.Quiz.App.model.Question;
import com.sigar.Quiz.App.service.AnswerValidator;
import com.sigar.Quiz.App.service.QuestionService;
import com.sigar.Quiz.App.sessions.Session;
import com.sigar.Quiz.App.sessions.SessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    public static final Logger logger = LoggerFactory.getLogger(SessionManager.class);

    private final QuestionService questionService;
    private final SessionManager sessionManager;
    @Autowired
    public QuizController(QuestionService questionService, SessionManager sessionManager) {
        this.questionService = questionService;
        this.sessionManager = sessionManager;
    }

    @PostMapping("/sessions")
    public ResponseEntity<?> createSession(@RequestBody UserDTO userDTO){
        try {
            Session session =  sessionManager.createSession(userDTO);
            return ResponseEntity.ok(new SessionResponseDTO(session.getSessionId()));
        }catch (Exception e){
            logger.error("Session creation failed", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Session creation failed with error " + e.getMessage());
        }
    }

    @GetMapping("/sessions/{sessionId}/users/{userId}/questions/random")
    public ResponseEntity<?> getRandomQuestion(@PathVariable Long sessionId, @PathVariable Long userId){
        logger.info("Generating random question for userId {}", userId);
        if (!sessionManager.isvalidSession(sessionId, userId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid session or user ID.");
        }
        try {
            Session session = sessionManager.getSessionByUserId(userId);
            Question question = questionService.getRandomQuestion(session);
         //   logger.info("Generated question: {}", question.getQuestionStatement());
            return ResponseEntity.ok(new QuestionDTO(question.getQuestionId(), question.getQuestionStatement(),question.getOptions()));
        } catch (Exception e) {
            logger.error("Error generating question", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to generate question: " + e.getMessage());
        }
    }
    @PostMapping("/sessions/{sessionId}/answer")
    public ResponseEntity<?> submitAnswer(@PathVariable Long sessionId,
                                          @RequestBody AnswerRequestDTO answerRequestDTO){

        Question question = questionService.getQuestionById(answerRequestDTO.questionId());
        if(!sessionManager.isvalidSession(sessionId, answerRequestDTO.userId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid session  or userID.");
        }
        AnswerDetails answerDetails = AnswerValidator.validateAnswer(question, answerRequestDTO.responses());
        sessionManager.updateSessionResults(sessionId,answerDetails);
        return ResponseEntity.ok(new AnswerResponseDTO(answerDetails));

    }

    @GetMapping("/sessions/{sessionId}/results")
    public ResponseEntity<?> getSubmissionResults(@PathVariable Long sessionId){
        Session session = sessionManager.getSessionBySessionId(sessionId);
        if (session == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid session Id.");
        }
        List<AnswerDetails> answerDetailsList = sessionManager.getSessionResults(sessionId);
        return ResponseEntity.ok(new ResultsDTO(answerDetailsList));
    }
}
