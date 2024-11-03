package com.utn.supergym.configuration.handler;

import com.utn.supergym.utils.TestController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({CustomExceptionHandler.class, TestController.class})
class CustomExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void whenAltaExceptionThrown_thenStatusUnprocessableEntity() throws Exception {
        mockMvc.perform(get("/alta-exception")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.mensaje", is("AltaException occurred")));
    }

    @Test
    void whenBadRequestExceptionThrown_thenStatusBadRequest() throws Exception {
        mockMvc.perform(get("/bad-request-exception")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.mensaje", is("BadRequestException occurred")));
    }

    @Test
    void whenNoSuchElementExceptionThrown_thenStatusNoContent() throws Exception {
        mockMvc.perform(get("/no-such-element-exception")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$.mensaje", is("NoSuchElementException occurred")));
    }

    @Test
    void whenGenericExceptionThrown_thenStatusInternalServerError() throws Exception {
        mockMvc.perform(get("/generic-exception")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.mensaje", is("Exception occurred")));
    }
}