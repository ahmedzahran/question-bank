package org.zahran.questionbank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zahran.questionbank.entities.Category;
import org.zahran.questionbank.entities.Question;
import org.zahran.questionbank.repositories.CategoryRepository;
import org.zahran.questionbank.services.CategoryService;
import org.zahran.questionbank.services.QuestionService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    CategoryService categoryService;

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/all")
    public String all(
            @RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("name") Optional<String> name,
            Model model)
    {

        int evalPageSize = pageSize.orElse(2);

        int evalPage = page.filter(p -> p >= 1)
                .map(p -> p - 1)
                .orElse(0);

        Pageable pageable = PageRequest.of(evalPage,evalPageSize, Sort.by("id").descending());

        Page<Question> questions = questionService.listAll(pageable);


        model.addAttribute("questions",questions);

        return  "questions/index";
    }

    @GetMapping("/create")
    public String create(@ModelAttribute("question") Question question,Model model){

        List<Category> categories = categoryService.getAllCategories();

        model.addAttribute("categories",categories);

        return "questions/form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("question") Question question, BindingResult result,Model model, RedirectAttributes redirectAttributes){

        if (result.hasErrors()){
            List<Category> categories = categoryService.getAllCategories();

            model.addAttribute("categories",categories);

            return "questions/form";
        }

        Category cat = categoryService.findCategoryById(question.getCategory().getId());

        System.out.println(cat);
        question.setCategory(cat);
        questionService.saveQuestion(question);

        redirectAttributes.addFlashAttribute("success","question created success");

        return "redirect:/questions/all";
    }
}
