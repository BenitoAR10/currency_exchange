package arquitectura.software.demo_c_e.dto;

import java.math.BigDecimal;

public class ExchangeDto {
    private RequestDto request;
    private BigDecimal result;
    private InfoDto info;

    public ExchangeDto() {
    }

    public ExchangeDto(RequestDto request, BigDecimal result, InfoDto info) {
        this.request = request;
        this.result = result;
        this.info = info;
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

    public InfoDto getInfo() {
        return info;
    }

    public void setInfo(InfoDto info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "ExchangeDto{" +
                "request=" + request +
                ", result=" + result +
                ", info=" + info +
                '}';
    }
}
