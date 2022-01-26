package com.trainingapps.forex.currencycalculator.repository;


import com.trainingapps.forex.currencycalculator.entity.Calculator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculatorRepository extends JpaRepository<Calculator,Long> {
//    public ResponseTemplateVO findByCalculatorId(Long calculatorId);

}
