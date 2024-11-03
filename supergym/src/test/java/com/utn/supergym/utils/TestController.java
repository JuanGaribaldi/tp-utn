package com.utn.supergym.utils;

import com.utn.supergym.exceptions.AltaException;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/alta-exception")
    public void throwAltaException() throws AltaException {
        throw new AltaException("AltaException occurred");
    }

    @GetMapping("/bad-request-exception")
    public void throwBadRequestException() throws BadRequestException {
        throw new BadRequestException("BadRequestException occurred");
    }

    @GetMapping("/no-such-element-exception")
    public void throwNoSuchElementException() {
        throw new NoSuchElementException("NoSuchElementException occurred");
    }

    @GetMapping("/generic-exception")
    public void throwGenericException() {
        throw new RuntimeException("Exception occurred");
    }
}