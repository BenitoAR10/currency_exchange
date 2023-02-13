package arquitectura.software.demo_c_e.api;


import arquitectura.software.demo_c_e.bl.CurrencyBl;
import arquitectura.software.demo_c_e.dto.ExchangeDto;
import arquitectura.software.demo_c_e.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1")
public class CurrencyApi {

    private CurrencyBl currencyBl;


    public CurrencyApi(CurrencyBl currencyBl) {
        this.currencyBl = currencyBl;
    }

    @GetMapping("/currency")
    public ResponseEntity<ResponseDto<ExchangeDto>> getExchange(@RequestParam String from, @RequestParam String to, @RequestParam BigDecimal amount){
        ExchangeDto exchangeDto = currencyBl.exchange(from, to, amount);
        ResponseDto<ExchangeDto> responseDto = new ResponseDto<ExchangeDto>(exchangeDto, true, null);
        return ResponseEntity.ok(responseDto);
    }
}
