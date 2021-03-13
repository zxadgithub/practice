package vip.linhs.stock.config;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import vip.linhs.stock.exception.FieldInputException;
import vip.linhs.stock.exception.ServiceException;
import vip.linhs.stock.model.vo.CommonResponse;

@ControllerAdvice
public class ApiExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(FieldInputException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResponse handleParamsException(FieldInputException e, HttpServletRequest request) {
        logger.error("{}: bad request", request.getRequestURI());
        List<FieldError> fieldErrors = e.getFieldErrors();
        StringBuilder sb = new StringBuilder();
        for (FieldError error : fieldErrors) {
            String field = error.getField();
            String message = error.getDefaultMessage();
            sb.append(field + ": " + message + ", ");
            logger.error("{}:{}", field, message);
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return CommonResponse.buildResponse(sb.toString());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public CommonResponse handleResourceNotFoundException(ResourceNotFoundException e,
            HttpServletRequest request) {
        logger.error("{}: resource not found", request.getRequestURI());
        return CommonResponse.buildResponse("resource not found");
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public CommonResponse handleServiceException(ServiceException e, HttpServletRequest request) {
        logger.error("{}: service error", request.getRequestURI());
        logger.error(e.getMessage(), e);
        return CommonResponse.buildResponse(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public CommonResponse handleUnknowException(Exception e, HttpServletRequest request) {
        logger.error("{}: internal server error", request.getRequestURI());
        logger.error(e.getMessage(), e);
        return CommonResponse.buildResponse("Internal Server Error");
    }

}
