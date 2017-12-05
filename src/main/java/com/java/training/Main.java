package com.java.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static com.java.training.OperationType.MULTIPLY;

public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Calculator calc = (Calculator) ctx.getBean("basicCalculator");
        System.out.println(calc.calculate(MULTIPLY, 2, 5));
    }
}
