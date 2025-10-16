package store.kanggyeonggu.api.calculator.service;

import org.springframework.stereotype.Service;
import store.kanggyeonggu.api.calculator.domain.CalculatorDTO;

@Service
public class CalculatorService {
    // 들여쓰기 해야 자식이 됨
    public boolean calculator(CalculatorDTO calculatorDTO) {
        System.out.println("✅ 서비스로 들어옴.");
        System.out.println("전달된 연산자: " + calculatorDTO.getOperator());
        // ⭐️ Controller에서 계산하여 전달한 최종 결과 (result)를 DTO에서 가져와 출력
        System.out.println("🔥 Controller가 계산해서 넘겨준 최종 결과 (result): " + calculatorDTO.getResult());
        return true;
    }
}
