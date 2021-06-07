package nl.inholland.exam.ships.BramSierhuis.error;

import nl.inholland.exam.ships.BramSierhuis.model.dto.ExceptionDTO;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Custom Exception handler to handle errors thrown in the services
//Shows the message to the end user
@ControllerAdvice
public class ResponseStatusExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ResponseStatusException.class })
    protected ResponseEntity<Object> handleResponseStatusException(ResponseStatusException ex, WebRequest request) {
        ExceptionDTO dto = new ExceptionDTO(ex.getReason(), ex.getMessage());
        return handleExceptionInternal(ex, dto, new HttpHeaders(),
                HttpStatus.valueOf(ex.getStatus().value()), request);
    }
}
