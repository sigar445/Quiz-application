package com.sigar.Quiz.App.utils;

import com.sigar.Quiz.App.model.Question;
import com.sigar.Quiz.App.repo.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SampleDataLoader implements CommandLineRunner {

    @Autowired
    private QuestionsRepository questionsRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Question> sampleQuestions = new ArrayList<>();

        sampleQuestions.add(new Question(
                "What is the capital of France?",
                Arrays.asList("Paris", "London", "Berlin"),
                Arrays.asList(0) // Answer: Paris (index 0)
        ));

        sampleQuestions.add(new Question(
                "What is the tallest mountain in the world?",
                Arrays.asList("Mount Everest", "K2", "Kangchenjunga"),
                Arrays.asList(0) // Answer: Mount Everest (index 0)
        ));
        sampleQuestions.add(new Question(
                "Which countries lies in asia?",
                Arrays.asList("Usa", "China", "Brazil","Thailand"),
                Arrays.asList(1,3)
        ));

        sampleQuestions.add(new Question(
                "Which of the following are continents?",
                Arrays.asList("United Kingdom","Asia", "Australia", "China"),
                Arrays.asList(1,2) // Answer: Mount Everest (index 0)
        ));
        sampleQuestions.add(new Question(
                "What is the largest planet in our solar system?",
                Arrays.asList("Earth", "Mars", "Jupiter", "Saturn"),
                Arrays.asList(2) // Answer: Jupiter (index 2)
        ));

        sampleQuestions.add(new Question(
                "Which element has the chemical symbol 'O'?",
                Arrays.asList("Oxygen", "Gold", "Osmium", "Hydrogen"),
                Arrays.asList(0) // Answer: Oxygen (index 0)
        ));

        sampleQuestions.add(new Question(
                "Who wrote 'Romeo and Juliet'?",
                Arrays.asList("William Shakespeare", "Jane Austen", "Mark Twain", "Charles Dickens"),
                Arrays.asList(0) // Answer: William Shakespeare (index 0)
        ));

        sampleQuestions.add(new Question(
                "What is the square root of 64?",
                Arrays.asList("6", "8", "10", "12"),
                Arrays.asList(1) // Answer: 8 (index 1)
        ));

        sampleQuestions.add(new Question(
                "Which of the following are prime numbers?",
                Arrays.asList("2", "4", "5", "9"),
                Arrays.asList(0, 2) // Answers: 2 and 5 (indices 0, 2)
        ));

        sampleQuestions.add(new Question(
                "Which animal is known as the 'King of the Jungle'?",
                Arrays.asList("Elephant", "Tiger", "Lion", "Gorilla"),
                Arrays.asList(2) // Answer: Lion (index 2)
        ));

        sampleQuestions.add(new Question(
                "Which of the following are programming languages?",
                Arrays.asList("Python", "HTML", "C++", "CSS"),
                Arrays.asList(0, 2) // Answers: Python and C++ (indices 0, 2)
        ));

        sampleQuestions.add(new Question(
                "What is the smallest country in the world?",
                Arrays.asList("Vatican City", "Monaco", "San Marino", "Liechtenstein"),
                Arrays.asList(0) // Answer: Vatican City (index 0)
        ));

        sampleQuestions.add(new Question(
                "Which of these are mammals?",
                Arrays.asList("Dolphin", "Crocodile", "Shark", "Kangaroo"),
                Arrays.asList(0, 3) // Answers: Dolphin and Kangaroo (indices 0, 3)
        ));

        sampleQuestions.add(new Question(
                "What is the boiling point of water at sea level?",
                Arrays.asList("90°C", "100°C", "110°C", "120°C"),
                Arrays.asList(1) // Answer: 100°C (index 1)
        ));

        sampleQuestions.add(new Question(
                "Which of the following are renewable energy sources?",
                Arrays.asList("Solar", "Coal", "Wind", "Oil"),
                Arrays.asList(0, 2) // Answers: Solar and Wind (indices 0, 2)
        ));
        sampleQuestions.add(new Question(
                "Which countries are part of the United Kingdom?",
                Arrays.asList("England", "France", "Scotland", "Ireland"),
                Arrays.asList(0, 2) // Answers: England and Scotland (indices 0, 2)
        ));

        sampleQuestions.add(new Question(
                "What are the primary colors?",
                Arrays.asList("Red", "Green", "Blue", "Yellow"),
                Arrays.asList(0, 2, 3) // Answers: Red, Blue, Yellow (indices 0, 2, 3)
        ));

        sampleQuestions.add(new Question(
                "Which of these are programming languages?",
                Arrays.asList("Python", "HTML", "Java", "CSS"),
                Arrays.asList(0, 2) // Answers: Python and Java (indices 0, 2)
        ));

        sampleQuestions.add(new Question(
                "Which planets are known as gas giants?",
                Arrays.asList("Mars", "Jupiter", "Saturn", "Venus"),
                Arrays.asList(1, 2) // Answers: Jupiter and Saturn (indices 1, 2)
        ));

        sampleQuestions.add(new Question(
                "Which of the following are considered vegetables?",
                Arrays.asList("Carrot", "Apple", "Broccoli", "Strawberry"),
                Arrays.asList(0, 2) // Answers: Carrot and Broccoli (indices 0, 2)
        ));

        sampleQuestions.add(new Question(
                "What are the components of the water cycle?",
                Arrays.asList("Evaporation", "Condensation", "Erosion", "Precipitation"),
                Arrays.asList(0, 1, 3) // Answers: Evaporation, Condensation, Precipitation (indices 0, 1, 3)
        ));

        sampleQuestions.add(new Question(
                "Which of these are famous works of Shakespeare?",
                Arrays.asList("Hamlet", "Pride and Prejudice", "Macbeth", "1984"),
                Arrays.asList(0, 2) // Answers: Hamlet and Macbeth (indices 0, 2)
        ));

        sampleQuestions.add(new Question(
                "Which of the following are types of clouds?",
                Arrays.asList("Cumulus", "Nimbus", "Aurora", "Stratus"),
                Arrays.asList(0, 1, 3) // Answers: Cumulus, Nimbus, Stratus (indices 0, 1, 3)
        ));

        sampleQuestions.add(new Question(
                "What are examples of input devices for a computer?",
                Arrays.asList("Keyboard", "Monitor", "Mouse", "Speaker"),
                Arrays.asList(0, 2) // Answers: Keyboard and Mouse (indices 0, 2)
        ));

        sampleQuestions.add(new Question(
                "Which of these are elements from the periodic table?",
                Arrays.asList("Hydrogen", "Water", "Oxygen", "Salt"),
                Arrays.asList(0, 2) // Answers: Hydrogen and Oxygen (indices 0, 2)
        ));

        questionsRepository.saveAll(sampleQuestions);

        System.out.println("Successfully added sample questions!");
    }
}