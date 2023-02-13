package arquitectura.software.demo_c_e.exception;

import arquitectura.software.demo_c_e.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ApiExepcion {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseDto<Void>> handleIllegalArgumentException(IllegalArgumentException e){
        ResponseDto<Void> responseDto = new ResponseDto<>();
        responseDto.setState(false);
        responseDto.setMessage(e.getMessage());
        return ResponseEntity.badRequest().body(responseDto);
    }

}
