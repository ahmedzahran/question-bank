package org.zahran.questionbank.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zahran.questionbank.ConstrainDeleteException;
import org.zahran.questionbank.entities.Category;
import org.zahran.questionbank.services.CategoryService;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
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

        Page<Category> categories = categoryService.listAll(pageable,name);


        model.addAttribute("categories",categories);

        return "categories/index";
    }

    @GetMapping("/create")
    public String createCategory(@ModelAttribute("cat") Category category){
        return "categories/form";
    }

    @PostMapping("/save")
    public String saveCategory(@Valid @ModelAttribute("cat") Category cat, BindingResult result, RedirectAttributes redirect){

        if (result.hasErrors()){
            return "categories/form";
        }
        categoryService.saveCategory(cat);

        redirect.addFlashAttribute("success","Category Created Successfully");
        return "redirect:/categories/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id,RedirectAttributes redirect){
        categoryService.deleteCategory(id);
        redirect.addFlashAttribute("success","Category Deleted Successfully");

        return "redirect:/categories/all";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") Long id,Model model,RedirectAttributes red){

        Category category = categoryService.findCategoryById(id);

        System.out.println(category);

        model.addAttribute("cat",category);

        return "categories/form";

    }
    @ExceptionHandler(ConstrainDeleteException.class)
    public String handleConstrainDeleteException(ConstrainDeleteException e, RedirectAttributes attributes){
        System.out.println("test");
        attributes.addFlashAttribute("error",e.getMessage());
        return "redirect:/categories/all";
    }
}
