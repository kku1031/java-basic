package store.kanggyeonggu.api.calculator.domain;

// 하나의 DTO로 입력과 출력을 모두 처리
public class CalculatorDTO {

    // 입력값 (Request 역할: HTML input name과 일치해야 함)
    private int num1;
    private int num2;
    private String operator;
    private int result;

    // 기본 생성자는 Spring이 폼 데이터를 바인딩할 때 필수입니다.
    public CalculatorDTO() {
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

}