package store.kanggyeonggu.api.calculator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// 하나의 DTO로 입력과 출력을 모두 처리
public class CalculatorDTO {

    // 입력값 (Request 역할: HTML input name과 일치해야 함)
    private int num1;
    private int num2;
    private String operator;

}