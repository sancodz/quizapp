package com.sathiya.quizapp.controller;

import com.sathiya.quizapp.model.Question;
import com.sathiya.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("allQuestions")
    private List<Question> GetAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    private List<Question> GetQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/addQuestion")
    private ResponseEntity<String> AddQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
        return ResponseEntity.ok("Question added successfully");
    }

    @PostMapping("/addQuestions")
    private ResponseEntity<String> AddQuestions(@RequestBody List<Question> questions) {
        questionService.addQuestions(questions);
        return ResponseEntity.ok("Questions added successfully");
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<String> DeleteQuestion(@PathVariable int id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.ok("Question deleted successfully");
    }

}
    