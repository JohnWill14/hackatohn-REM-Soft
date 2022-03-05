package br.com.remsoft.equipe3.hackathon.handler;

import br.com.remsoft.equipe3.hackathon.error.BadRequestException;
import br.com.remsoft.equipe3.hackathon.error.EntityNotFoundException;
import br.com.remsoft.equipe3.hackathon.handler.schema.ExceptionSchema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleAllBadRequestException(BadRequestException bre){
        ExceptionSchema exceptionSchema = ExceptionSchema.builder()
                .messageException(bre.getMessage())
                .typeErro(bre.getClass().getSimpleName())
                .erroCode(HttpStatus.BAD_REQUEST)
                .timeException(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(exceptionSchema, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleAllEntityNotFounException(EntityNotFoundException enfe){
        ExceptionSchema exceptionSchema = ExceptionSchema.builder()
                .messageException(enfe.getMessage())
                .typeErro(enfe.getClass().getSimpleName())
                .erroCode(HttpStatus.BAD_REQUEST)
                .timeException(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(exceptionSchema, HttpStatus.BAD_REQUEST);
    }
}
