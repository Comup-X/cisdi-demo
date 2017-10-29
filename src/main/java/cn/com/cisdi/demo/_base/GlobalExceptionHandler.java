package cn.com.cisdi.demo._base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Comup
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //添加全局异常处理流程，根据需要设置需要处理的异常
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object methodArgumentNotValidHandler(HttpServletRequest request, Exception exception) {
        logger.error("Unhandled Exception", exception);
        return Result.error(exception.getMessage());
    }
}