package store.kanggyeonggu.api.calculator.service;

import store.kanggyeonggu.api.calculator.domain.CalculatorDTO;

public interface CalculatorService {
    // 들여쓰기 해야 자식이 됨
    public int add(CalculatorDTO calculatorDTO); // 추상 메소드

    public int substract(CalculatorDTO calculatorDTO); // 추상 메소드

    public int multiply(CalculatorDTO calculatorDTO); // 추상 메소드

    public int divide(CalculatorDTO calculatorDTO); // 추상 메소드

}
