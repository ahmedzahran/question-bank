package org.zahran.questionbank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuestionBankController {


    @GetMapping("/")
    public String index(){
        return "index";
    }

//    @GetMapping("/category")
//    public String showAllCategories(Model model){
//        model.addAttribute("categories",questionBankService.fetchAllCategories());
//        return "categories";
//    }
//
//
//    @GetMapping("/questions")
//    public String showAllQuestions(Model model){
//        model.addAttribute("questions",questionBankService.fetchAllQuestionAnswers());
//        return "questions";
//    }
//
//    @GetMapping("category/add")
//    public String addCategory(@ModelAttribute("category")Category category){
//        return "addCategory";
//    }
//
//    @GetMapping("questions/add")
//    public String addQuestion(Model model){
//
//        model.addAttribute("qn",new Question());
//        model.addAttribute("categories",questionBankService.fetchAllCategories());
//        return "addQuestion";
//    }
//
//    @PostMapping("/category/save")
//    public String saveCategory(@ModelAttribute("category")Category category){
//
//        questionBankService.saveCategory(category);
//
//        return "redirect:/category";
//    }
//
//    @PostMapping("/questions/save")
//    public String saveQuestion(@ModelAttribute("qn") Question question){
//
//        questionBankService.saveQuestion(question);
//
//        return "redirect:/questions";
//
//    }
//
//    @GetMapping("questions/edit/{id}")
//    public String editQuestion(@PathVariable("id")Long id){
//        return "addQuestion";
//    }
}
