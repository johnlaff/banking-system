package br.com.treebank.adapters.inbound.response;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
public class ErrorResponse {
    private final String timestamp;
    private final String message;
    private final List<String> details;

    public ErrorResponse(String message, List<String> details) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm:ss");
        this.timestamp = LocalDateTime.now().format(formatter);
        this.message = message;
        this.details = details;
    }
}