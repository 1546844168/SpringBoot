package com.jf.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;

/**
 * 处理全局异常
 *
 * @author 江峰
 * @date 2020/6/29 16:28
 */

@ControllerAdvice
@Component
@RestController
@Slf4j
public class GlobalExceptionHander {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String hello(Exception e) {
        log.error("{}", e);
        return e.getMessage();
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handle(ValidationException exception) {
        if (exception instanceof ConstraintViolationException) {
            ConstraintViolationException exs = (ConstraintViolationException) exception;

            Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
            for (ConstraintViolation<?> item : violations) {
                //打印验证不通过的信息
                System.out.println(item.getMessage());
            }
        }
        return exception.getMessage();
    }
}
