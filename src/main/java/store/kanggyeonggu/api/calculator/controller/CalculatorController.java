package store.kanggyeonggu.api.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import store.kanggyeonggu.api.calculator.domain.CalculatorDTO;
import store.kanggyeonggu.api.calculator.service.CalculatorService;

@Controller
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService CalculatorService) {
        this.calculatorService = CalculatorService;
    }

    // 하나의 컨트롤러로 통합
    @GetMapping("/calculator")
    public String calculate(
            @RequestParam("num1") int num1,
            @RequestParam("num2") int num2,
            @RequestParam("operator") String operator

    ) {

        System.out.println("계산기로 들어옴");
        System.out.println("전달된 첫 번째 숫자: " + num1);
        System.out.println("전달된 두 번째 숫자: " + num2);
        System.out.println("전달된 연산자: " + operator);

        // DTO 생성 및 값 저장
        CalculatorDTO calculatorDTO = new CalculatorDTO();
        calculatorDTO.setNum1(num1);
        calculatorDTO.setNum2(num2);
        calculatorDTO.setOperator(operator);

        int calculatedResult = 0;
        boolean isValidOperation = true;

        switch (operator) {
            case "+":
                calculatedResult = num1 + num2;
                break;
            case "-":
                calculatedResult = num1 - num2;
                break;
            case "*":
                calculatedResult = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("❌ 오류: 0으로 나눌 수 없습니다.");
                    isValidOperation = false;
                } else {
                    calculatedResult = num1 / num2;
                }
                break;
            default:
                System.out.println("❌ 오류: 알 수 없는 연산자입니다.");
                isValidOperation = false;
                break;
        }

        calculatorDTO.setResult(calculatedResult);

        boolean isSuccess = calculatorService.calculator(calculatorDTO);

        if (isValidOperation && isSuccess) {
            System.out.println("최종 결과: " +
                    operator + " 연산 성공. " +
                    num1 + " " + operator + " " + num2 + " = " + calculatedResult);
        } else {
            System.out.println("최종 실패: 연산자 오류 또는 Service 처리 실패.");
        }

        return "redirect:/";
    }
}
