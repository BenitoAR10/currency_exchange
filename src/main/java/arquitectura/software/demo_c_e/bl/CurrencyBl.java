package arquitectura.software.demo_c_e.bl;

import arquitectura.software.demo_c_e.dto.ExchangeDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyBl {

    public ExchangeDto exchange(String from, String to, BigDecimal amount){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.apilayer.com/exchangerates_data/convert?from=" + from + "&to=" + to + "&amount=" + amount)
                .addHeader("apikey", "YEraXsSahmYnVTklREwJ6uvCDwm3VpVS")
                .build();

        try{
            Response response = client.newCall(request).execute();
            String result = response.body().string();
            System.out.println(result);

            ObjectMapper mapper = new ObjectMapper();
            ExchangeDto exchangeDto = mapper.readValue(result, ExchangeDto.class);
            return exchangeDto;
        } catch (Exception e){
            throw new RuntimeException("Error al llamar la API");
        }
    }
}
