package com.apple.shop.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handler(){
        // 같은 클래스 내부에서 에러가 난다면 해당 메서드가 에러를 잡아서 처리한다.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("공통에러 처리하겠음.");
    }
}
