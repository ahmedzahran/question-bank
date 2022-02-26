package org.zahran.questionbank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zahran.questionbank.entities.Answer;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
