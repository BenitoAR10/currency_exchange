package arquitectura.software.demo_c_e.api;


import arquitectura.software.demo_c_e.bl.CurrencyBl;
import arquitectura.software.demo_c_e.dto.ExchangeDto;
import arquitectura.software.demo_c_e.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Currency;

@RestController
@RequestMapping("/api/v1")
public class CurrencyApi {

    private static Logger logger = LoggerFactory.getLogger(Currency.class);
    private CurrencyBl currencyBl;


    public CurrencyApi(CurrencyBl currencyBl) {
        this.currencyBl = currencyBl;
    }

    @GetMapping("/currency")
    public ResponseEntity<ResponseDto<ExchangeDto>> getExchange(@RequestParam String from, @RequestParam String to, @RequestParam BigDecimal amount){
        logger.info("Empezando la logica de negocio");
        ExchangeDto exchangeDto = currencyBl.exchange(from, to, amount);
        ResponseDto<ExchangeDto> responseDto = new ResponseDto<ExchangeDto>(exchangeDto, true, null);
        logger.info("Enviando Respuesta");
        return ResponseEntity.ok(responseDto);
    }
}
