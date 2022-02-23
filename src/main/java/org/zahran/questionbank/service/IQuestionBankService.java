package org.zahran.questionbank.service;

import org.zahran.questionbank.data.Category;
import org.zahran.questionbank.data.QuestionAnswers;

import java.util.List;

public interface IQuestionBankService {
    List<Category> fetchAllCategories();
    List<QuestionAnswers> fetchAllQuestionAnswers();
}
