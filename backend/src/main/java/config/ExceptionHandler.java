package config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

import static org.springframework.http.HttpStatus.HTTP_VERSION_NOT_SUPPORTED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler (value = CustomException.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundException(CustomException e) {
        ErrorMessage message = new ErrorMessage(
                201,
                new Date(),
                e.getMessage(),
                "description");
        return new ResponseEntity<>(message, NOT_FOUND);
    }
}
