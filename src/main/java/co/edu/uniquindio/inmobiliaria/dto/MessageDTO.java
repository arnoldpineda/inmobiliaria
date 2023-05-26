package co.edu.uniquindio.inmobiliaria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class MessageDTO<T> {
    private HttpStatus status;
    private boolean error;
    private T response;
}
