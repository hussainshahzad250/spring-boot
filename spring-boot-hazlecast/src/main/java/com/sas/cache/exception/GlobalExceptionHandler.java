package com.sas.cache.exception;

import java.io.EOFException;
import java.io.FileNotFoundException;

import javax.net.ssl.SSLHandshakeException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String ERROR_MSG = "Something went Wrong, Please try Later";

    @ExceptionHandler(value = FileNotFoundException.class)
    @ResponseBody
    public ResponseEntity<Object> handleFileNotFoundException(FileNotFoundException ex) {
        log.info("FileNotFound Exception occurs => {}", ex);
        return new ResponseEntity<>(new Response("File does not exist", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<Object> handleException(Exception ex) {
        log.info("Exception  occurs => {}", ex);
        return new ResponseEntity<>(new Response(ERROR_MSG, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
        log.info("RuntimeException  occurs => {}", ex);
        return new ResponseEntity<>(new Response(ERROR_MSG, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ObjectNotFoundException.class)
    @ResponseBody
    public ResponseEntity<Object> handleFileNotFoundException(ObjectNotFoundException ex) {
        log.info("ObjectNotFoundException Exception occurs => {}", ex);
        return new ResponseEntity<>(new Response(ex.getMessage(), ex.getResponseObject(), ex.getHttpStatus()),
                ex.getHttpStatus());
    }

    @ExceptionHandler(value = BadRequestException.class)
    @ResponseBody
    public ResponseEntity<Object> handleFileNotFoundException(BadRequestException ex) {
        log.info("BadRequest Exception occurs => {}", ex);
        return new ResponseEntity<>(new Response(ex.getMessage(), ex.getHttpStatus()), HttpStatus.OK);
    }


    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ResponseEntity<Object> handleFileNotFoundException(HttpRequestMethodNotSupportedException ex) {
        log.info("HttpRequestMethodNotSupportedException occurs => {}", ex);
        return new ResponseEntity<>(new Response(ex.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public ResponseEntity<Object> handleFileNotFoundException(MissingServletRequestParameterException ex) {
        log.info("MissingServletRequestParameterException Exception occurs => {}", ex);
        return new ResponseEntity<>(new Response(ex.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = SSLHandshakeException.class)
    @ResponseBody
    public ResponseEntity<Response> handleSSLHandshakeException(SSLHandshakeException ex) {
        log.info("SSLHandshake Exception occurs => {}", ex);
        return new ResponseEntity<>(new Response(ERROR_MSG, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EOFException.class)
    @ResponseBody
    public ResponseEntity<Object> handleEOFException(EOFException ex) {
        log.info("EOF Exception occurs => {}", ex);
        return new ResponseEntity<>(new Response(ERROR_MSG, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

}