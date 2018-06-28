package Application.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Datos Incorrectos")
public class DatosIncorrectosException extends RuntimeException {

}