package arquitectura.software.demo_c_e.dto;

import java.math.BigDecimal;

public class ExchangeDto {
    private RequestDto query;
    private BigDecimal result;
    private InfoDto info;
    private boolean success;
    private String date;

    public ExchangeDto() {
    }

    public ExchangeDto(RequestDto query, BigDecimal result, InfoDto info, boolean success, String date) {
        this.query = query;
        this.result = result;
        this.info = info;
        this.success = success;
        this.date = date;
    }

    public RequestDto getQuery() {
        return query;
    }

    public void setQuery(RequestDto query) {
        this.query = query;
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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ExchangeDto{" +
                "query=" + query +
                ", result=" + result +
                ", info=" + info +
                ", success=" + success +
                ", date='" + date + '\'' +
                '}';
    }
}
