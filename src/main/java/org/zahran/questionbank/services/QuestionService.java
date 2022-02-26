package org.zahran.questionbank.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.zahran.questionbank.entities.Question;
import org.zahran.questionbank.repositories.QuestionRepository;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Page<Question> listAll(Pageable pageable){
        return questionRepository.findAll(pageable);
    }

    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }
}
