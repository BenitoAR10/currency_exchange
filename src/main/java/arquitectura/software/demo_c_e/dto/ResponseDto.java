package arquitectura.software.demo_c_e.dto;

public class ResponseDto <T>{

    private T data;
    private boolean state;
    private String message;

    public ResponseDto() {
    }

    public ResponseDto(T data, boolean state, String message) {
        this.data = data;
        this.state = state;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "data=" + data +
                ", state=" + state +
                ", message='" + message + '\'' +
                '}';
    }
}
