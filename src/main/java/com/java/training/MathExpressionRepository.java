package com.java.training;

import com.java.training.models.MathExpression;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MathExpressionRepository extends JpaRepository<MathExpression, Long> {
}
