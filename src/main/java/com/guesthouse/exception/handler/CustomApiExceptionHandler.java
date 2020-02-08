package com.guesthouse.exception.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.guesthouse.exception.EmailAlreadyExistsException;
import com.guesthouse.exception.ResourceNotFoundException;

@ControllerAdvice
public class CustomApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
            WebRequest request ) {

        List<String> errors = new ArrayList<String>();

        for ( FieldError error : ex.getBindingResult().getFieldErrors() ) {
            errors.add( error.getField() + ": " + error.getDefaultMessage() );
        }

        for ( ObjectError error : ex.getBindingResult().getGlobalErrors() ) {
            errors.add( error.getObjectName() + ": " + error.getDefaultMessage() );
        }

        ApiError apiError =
                new ApiError( HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors );

        return handleExceptionInternal(
                ex, apiError, headers, apiError.getStatus(), request );
    }


    @ExceptionHandler( value = ResourceNotFoundException.class )
    public ResponseEntity<ApiError> handleResourceNotFoundException( ResourceNotFoundException ex,
            HttpServletRequest request ) {

        ApiError error = new ApiError( HttpStatus.NOT_FOUND, "Resource Not Found",
                ex.getMessage() );

        return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( error );

    }


    @ExceptionHandler( value = EmailAlreadyExistsException.class )
    public ResponseEntity<ApiError> handleEmailAlreadyExistException(
            EmailAlreadyExistsException ex, HttpServletRequest request ) {

        ApiError error = new ApiError( HttpStatus.BAD_REQUEST, "Email already exissts",
                ex.getMessage() );

        return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( error );

    }
}
