package br.com.treebank.adapters.inbound.exception;

import br.com.treebank.adapters.inbound.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> details = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            String errorDetail = String.format("Campo %s: %s", error.getField(), error.getDefaultMessage());
            details.add(errorDetail);
        }

        ErrorResponse error = new ErrorResponse("Validação falhou", details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}