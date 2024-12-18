package com.sigar.Quiz.App.dto;


import com.sigar.Quiz.App.model.Question;

import java.util.List;

public record QuestionDTO(
    Long questionId,
    String questionStatement,List<String> options){

}
