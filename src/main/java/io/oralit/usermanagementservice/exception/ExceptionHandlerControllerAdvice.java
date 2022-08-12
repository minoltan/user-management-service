package io.oralit.usermanagementservice.exception;

import io.oralit.usermanagementservice.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Minoltan Issack on 8/11/2022
 */
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    Response handleBadRequest(final BadRequestException exception,
                              final HttpServletRequest request) {
        Response response = new Response();
        response.setSuccess(false);
        response.setErrorMessage(exception.getMessage());
        response.setRequestedURI(request.getRequestURI());
        response.setStatusInfo(HttpStatus.BAD_REQUEST.getReasonPhrase());
        return response;
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public @ResponseBody
    Response handleConflictException(final ConflictException exception,
                                     final HttpServletRequest request) {
        Response response = new Response();
        response.setSuccess(false);
        response.setErrorMessage(exception.getMessage());
        response.setRequestedURI(request.getRequestURI());
        response.setStatusInfo(HttpStatus.CONFLICT.getReasonPhrase());
        return response;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody
    Response handleNotFoundException(final NotFoundException exception,
                                     final HttpServletRequest request) {
        Response response = new Response();
        response.setSuccess(false);
        response.setErrorMessage(exception.getMessage());
        response.setRequestedURI(request.getRequestURI());
        response.setStatusInfo(HttpStatus.NOT_FOUND.getReasonPhrase());
        return response;
    }

}

