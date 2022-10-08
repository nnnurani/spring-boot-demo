package com.nurani.springbootdemo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
public record ApiException (String message,Throwable throwable,HttpStatus httpStatus,ZonedDateTime zonedDateTime){

}
