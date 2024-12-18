package com.sigar.Quiz.App.repo;

import com.sigar.Quiz.App.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionsRepository extends JpaRepository<Question, Long> {
    @Query("SELECT q FROM Question q WHERE q.questionId NOT IN :askedQuestionIds ORDER BY FUNCTION('RAND')")
    Page<Question> findRandomQuestions(@Param("askedQuestionIds") Set<Long> askedQuestionIds, Pageable pageable);


}
