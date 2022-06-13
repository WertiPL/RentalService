package com.example.rentalservice.Controller;

import com.example.rentalservice.Model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.ConnectException;
@RestControllerAdvice
public class GlobalControllerAdvice{

@ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<Void> handleNotFound() {
    return ResponseEntity.notFound().build();
}
    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<Void> handleNotFound502() {
        return ResponseEntity.status(502).build();
    }
/*    ConnectException exception;
    @ExceptionHandler(exception.class)
    public ResponseEntity<Void> handleConnectException() {
        return ResponseEntity.status(502).build();
    }*/
}

//httpserverexception

    /*
       private final ResponseEntity<Movie> responseOk = ResponseEntity.ok().build();
    private final ResponseEntity<Movie> responseNotFound = ResponseEntity.notFound().build();
    private final ResponseEntity<Movie> responseServerError = ResponseEntity.internalServerError().build();
    ConnectException exception;

       public ResponseEntity<Movie> resolveResponse(ResponseEntity<Movie> responseEntity){
        if (responseEntity.equals(responseOk))
            return responseOk;
        else if (responseEntity.equals(responseNotFound))
            return responseNotFound;
        else if(responseEntity.equals(responseServerError))
        {
            if (responseEntity.equals(ResponseEntity.status(500).build()))
            {
                    return ResponseEntity.status(502).build();
            }
            else if (responseEntity.equals(exception))
                return ResponseEntity.status(504).build();
            else
            {
                return responseServerError;
            }

        }

        else
            return responseEntity;
    }*/



