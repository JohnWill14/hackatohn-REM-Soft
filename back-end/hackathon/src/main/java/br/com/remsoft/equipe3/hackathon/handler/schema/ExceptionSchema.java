package br.com.remsoft.equipe3.hackathon.handler.schema;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionSchema {
    private String messageException;
    private String typeErro;
    private HttpStatus erroCode;
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    private LocalDateTime timeException;
}
