package store.kanggyeonggu.api.auth.domain;

//public 택배 상자에서 택배 상자는 누구나 볼수 있지만 안에 있는건 못보게 private으로 걸어둠
public class LoginDTO {

    //누구나 내용을 볼 수 있는 상태(따라서 방지 하지 위해서 private)
    private String name;
    private String password; //->속성과 기능이 있어야 하는데 기능이 없으니까 에러가 남.

    //DTO(Object 니까 객체 여야 되니까 속성과 기능이 있어야함)    
    // Getter (속성 값 읽기)
    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return password;
    }

    // Setter (속성 값 설정/변경)
    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //속성과 기능이 같이 생겼으니까 이제 객체로써 의미를 가짐.

}
