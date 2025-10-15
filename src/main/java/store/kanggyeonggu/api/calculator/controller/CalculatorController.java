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


    @GetMapping("/calculator/add")
    public String calculateAdd(@RequestParam("num1") int num1,
    @RequestParam("num2") int num2)
            { 
        System.out.println("덧셈 서비스로 들어옴");        
        System.out.println("덧셈 서비스로 전달된 첫번째 번호 : " + num1);
        System.out.println("덧셈 서비스로 전달된 두번째 번호 : " + num2);  
      
        CalculatorDTO calculatorDTO = new CalculatorDTO();

        calculatorDTO.setNum1(num1);
        calculatorDTO.setNum2(num2);        

        calculatorService.calculator(calculatorDTO);  

        return "calculator/add"; 
    }

    @GetMapping("/calculator/subtract")
    public String calculateSubtract(@RequestParam("num1") int num1,
    @RequestParam("num2") int num2)
            { 
        System.out.println("컨트롤러로 들어옴");
        System.out.println("화면에서 컨트롤러로 전달된 첫번째 값 : " + num1);
        System.out.println("화면에서 컨트롤러로 전달된 두번째 값 : " + num2);
      
        CalculatorDTO calculatorDTO = new CalculatorDTO();
        calculatorDTO. setNum1(num1);
        calculatorDTO. setNum2(num2);     

        calculatorService.calculator(calculatorDTO);       


        return "calculator/subtract"; 
    }

    @GetMapping("/calculator/gob")
    public String calculateGob(@RequestParam("num1") int num1,
    @RequestParam("num2") int num2)
            { 
        System.out.println("컨트롤러로 들어옴");
        System.out.println("화면에서 컨트롤러로 전달된 첫번째 값 : " + num1);
        System.out.println("화면에서 컨트롤러로 전달된 두번째 값 : " + num2);
      
        CalculatorDTO calculatorDTO = new CalculatorDTO();
        calculatorDTO. setNum1(num1);
        calculatorDTO. setNum2(num2);     

        calculatorService.calculator(calculatorDTO);       


        return "calculator/gob"; 
    }

    @GetMapping("/calculator/divide")
    public String calculateDivide(@RequestParam("num1") int num1,
    @RequestParam("num2") int num2)
            { 
        System.out.println("컨트롤러로 들어옴");
        System.out.println("화면에서 컨트롤러로 전달된 첫번째 값 : " + num1);
        System.out.println("화면에서 컨트롤러로 전달된 두번째 값 : " + num2);
      
        CalculatorDTO calculatorDTO = new CalculatorDTO();
        calculatorDTO. setNum1(num1);
        calculatorDTO. setNum2(num2);     

        calculatorService.calculator(calculatorDTO);       

        return "calculator/divide"; 
    }
}