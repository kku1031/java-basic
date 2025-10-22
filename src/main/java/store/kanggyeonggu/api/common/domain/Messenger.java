package store.kanggyeonggu.api.common.domain;

//성공 실패 여부
public class Messenger {

    private int code;
    private String message;

    // // 기본 생성자 (Spring이나 JSON 파싱 시 종종 필요합니다)
    // public Messenger() {
    // }

    // 💡 Getter: 외부에서 값을 읽어갈 수 있게 해줍니다.
    public int getCode() {
        return code;
    }

    // 💡 Setter: 외부에서 값을 설정할 수 있게 해줍니다.
    public void setCode(int code) {
        this.code = code;
    }

    // 💡 Getter
    public String getMessage() {
        return message;
    }

    // 💡 Setter
    public void setMessage(String message) {
        this.message = message;
    }
}
