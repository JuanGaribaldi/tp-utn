package com.utn.supergym.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.utn.supergym.services.PagoService;
import com.utn.supergym.utils.TestData;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class PagoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PagoService pagoService;

    @Value("${supergym.user}")
    private String user;

    @Value("${supergym.pass}")
    private String pass;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser(roles = "USER")
    void registrarPago() throws Exception {
        Mockito.doNothing().when(pagoService).darDeAltaPago(TestData.getPagoAltaRequest());

        mockMvc.perform(MockMvcRequestBuilders.post("/pagos")
                        .header(HttpHeaders.AUTHORIZATION, HttpHeaders.encodeBasicAuth(user, pass, StandardCharsets.UTF_8))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(TestData.getPagoAltaRequest())))
                .andExpect(status().isCreated())
                .andExpect(content().string(Matchers.blankOrNullString()))
                .andReturn();
    }
}