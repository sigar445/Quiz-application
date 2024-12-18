package com.sigar.Quiz.App.dto;

import java.util.List;

public record AnswerRequestDTO(Long userId,Long questionId,List<Integer> responses) {
}
