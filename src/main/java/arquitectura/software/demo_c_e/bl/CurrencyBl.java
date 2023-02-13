package arquitectura.software.demo_c_e.bl;

import arquitectura.software.demo_c_e.dto.ExchangeDto;
import arquitectura.software.demo_c_e.exception.ApiExepcion;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyBl {

    Logger logger = LoggerFactory.getLogger(CurrencyBl.class);

    public ExchangeDto exchange(String from, String to, BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("El monto debe ser mayor a 0");
        }

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.apilayer.com/exchangerates_data/convert?to="+to +"& from=" +from+"& amount="+ amount)
                .addHeader("apikey", "YEraXsSahmYnVTklREwJ6uvCDwm3VpVS")
                .build();

        try{
            logger.info("Invocando a la API");
            Response response = client.newCall(request).execute();
            logger.info("Procesando la respuesta");
            String result = response.body().string();
            //System.out.println("hola");
            //System.out.println(result);
            ObjectMapper mapper = new ObjectMapper();
            ExchangeDto exchangeDto = mapper.readValue(result, ExchangeDto.class);
            return exchangeDto;

        } catch (Exception e){
            logger.error("Error al llamar la API", e);
            throw new RuntimeException("Error al llamar la API");
        }
    }
}
