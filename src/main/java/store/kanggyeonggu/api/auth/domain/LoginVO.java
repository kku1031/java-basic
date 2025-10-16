package store.kanggyeonggu.api.auth.domain;

public class LoginVO {
    // 누구나 내용을 볼 수 있는 상태(따라서 방지 하지 위해서 private)
    private String name = "aaa";
    private String password = "bbb"; // ->속성과 기능이 있어야 하는데 기능이 없으니까 에러가 남.

    // DTO(Object 니까 객체 여야 되니까 속성과 기능이 있어야함)
    // Getter (속성 값 읽기)
    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return password;
    }

    // Setter가 쓰기니까 쓰는 부분을 없애기 위해서 지움
    // // Setter (속성 값 설정/변경)
    // public void setName(String name) {
    // this.name = name;
    // }

    // public void setPassword(String password) {
    // this.password = password;
    // }

}
