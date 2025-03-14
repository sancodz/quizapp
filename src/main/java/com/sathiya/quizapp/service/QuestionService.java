package com.sathiya.quizapp.service;

import com.sathiya.quizapp.model.Question;
import com.sathiya.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    public void addQuestions(List<Question> questions) {
        questionRepository.saveAll(questions);
    }

    public void deleteQuestion(int id) {
        questionRepository.deleteById(id);
    }
}
