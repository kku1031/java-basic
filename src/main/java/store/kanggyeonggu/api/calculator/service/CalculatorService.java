package store.kanggyeonggu.api.calculator.service;
import org.springframework.stereotype.Service;
import store.kanggyeonggu.api.calculator.domain.CalculatorDTO;

@Service
public class CalculatorService {
    //들여쓰기 해야 자식이 됨
    public boolean calculator(CalculatorDTO calculatorDTO) {
        System.out.println("덧셈 서비스로 들어옴");        
        System.out.println("덧셈 서비스로 전달된 첫번째 번호 : " + calculatorDTO.getNum1());
        System.out.println("덧셈 서비스로 전달된 두번째 번호 : " + calculatorDTO.getNum2());        
        return true;
    }
}
