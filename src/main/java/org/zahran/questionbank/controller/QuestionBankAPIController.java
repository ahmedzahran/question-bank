package org.zahran.questionbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zahran.questionbank.data.Category;
import org.zahran.questionbank.data.QuestionAnswers;
import org.zahran.questionbank.service.IQuestionBankService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionBankAPIController {

    @Autowired
    private IQuestionBankService questionBankService;

    @GetMapping("/questions")
    public List<QuestionAnswers> fetchAllQuestionAndAnswers(){
        return questionBankService.fetchAllQuestionAnswers();
    }

    @GetMapping("/categories")
    public List<Category> fetchAllCategories(){
        return questionBankService.fetchAllCategories();
    }
}
