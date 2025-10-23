package store.kanggyeonggu.api.calculator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculatorEntity {

    private int num1;
    private int num2;
    private String operator;

}
