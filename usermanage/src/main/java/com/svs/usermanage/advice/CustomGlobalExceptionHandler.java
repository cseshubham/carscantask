package com.svs.usermanage.advice;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // error handle for @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, headers, status);

    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> constraintViolationException(ConstraintViolationException ex) throws IOException {
        //response.sendError(HttpStatus.BAD_REQUEST.value());
        
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status",HttpStatus.BAD_REQUEST.value());
        
        body.put("errors", ex.getMessage());
        
        return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);
    }
    
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
    		HttpStatus status, WebRequest request) {
    	
    	Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        //Get all errors
        

        body.put("errors", "Required Input Type "+ex.getRequiredType()+"::"+ex.getCause());

        return new ResponseEntity<>(body, headers, status);
    	// TODO Auto-generated method stub
    	//return super.handleTypeMismatch(ex., headers, status, request);
    }
    
    @ExceptionHandler(NoSuchElementException.class)
    private ResponseEntity<Object> noSuchElementException(NoSuchElementException ex) {
		// TODO Auto-generated method stub
    	 Map<String, Object> body = new LinkedHashMap<>();
         body.put("timestamp", new Date());
         body.put("status",HttpStatus.NOT_FOUND.value());
         
         body.put("errors", ex.getMessage());
         
         return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);

	}
}
