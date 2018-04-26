package com.tw.biblioteca.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;


@RestController
public class ExceptionController implements ErrorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

    private static final String path = "/error";

    @RequestMapping(value = "/error", produces = MediaType.APPLICATION_JSON_VALUE)
    public Errors handleError(HttpServletRequest request) {
        LOGGER.warn(request.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI).toString());
        return Errors.endPointNotFound();
    }

    @Override
    public String getErrorPath() {
        return path;
    }
}
