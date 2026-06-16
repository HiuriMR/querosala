package br.com.querosala.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SalaException.class)
    public ResponseEntity<ResponseError> salaException(SalaException ex){

        ResponseError response = new ResponseError(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError> handlerValidationException(MethodArgumentNotValidException ex){
        String erros = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .reduce((a,b) -> a + "; " + b)
                .orElse("Erro de validação");

        ResponseError response = new ResponseError(
                erros,
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> aprovarException(Exception ex){

        ResponseError response = new ResponseError(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
