package org.zahran.questionbank.service;

import org.springframework.stereotype.Service;
import org.zahran.questionbank.data.Category;
import org.zahran.questionbank.data.CategoryRepository;
import org.zahran.questionbank.data.QuestionAnswers;
import org.zahran.questionbank.data.QuestionAnswersRepository;

import java.util.List;

@Service
public class QuestionBankService implements IQuestionBankService {

    private  final QuestionAnswersRepository questionAnswersRepository;
    private final CategoryRepository categoryRepository;

    public QuestionBankService(QuestionAnswersRepository questionAnswersRepository, CategoryRepository categoryRepository) {
        this.questionAnswersRepository = questionAnswersRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> fetchAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<QuestionAnswers> fetchAllQuestionAnswers() {
        return  questionAnswersRepository.findAll();
    }
}
