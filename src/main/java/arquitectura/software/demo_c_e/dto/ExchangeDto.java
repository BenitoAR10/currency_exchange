package arquitectura.software.demo_c_e.dto;

import java.math.BigDecimal;

public class ExchangeDto {
    private RequestDto request;
    private BigDecimal result;

    public ExchangeDto() {
    }

    public ExchangeDto(RequestDto request, BigDecimal result) {
        this.request = request;
        this.result = result;
    }

    public RequestDto getRequest() {
        return request;
    }

    public void setRequest(RequestDto request) {
        this.request = request;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ExchangeDto{" +
                "request=" + request +
                ", result=" + result +
                '}';
    }
}
