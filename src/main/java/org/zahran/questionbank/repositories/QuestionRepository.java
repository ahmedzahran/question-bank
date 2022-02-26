package org.zahran.questionbank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zahran.questionbank.entities.Question;

public interface QuestionRepository  extends JpaRepository<Question,Long> {
}
