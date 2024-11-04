package com.utn.supergym.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.utn.supergym.dtos.cliente.ClienteAltaRequest;
import com.utn.supergym.dtos.cliente.ClienteUpdateRequest;
import com.utn.supergym.services.ClienteService;
import com.utn.supergym.utils.TestData;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @Value("${supergym.user}")
    private String user;

    @Value("${supergym.pass}")
    private String pass;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser(roles = "USER")
    void darDeAltaCliente() throws Exception {
        Mockito.when(clienteService.darDeAltaCliente(ArgumentMatchers.any(ClienteAltaRequest.class)))
                .thenReturn(TestData.getClienteResponse());

        mockMvc.perform(MockMvcRequestBuilders.post("/clientes")
                        .header(HttpHeaders.AUTHORIZATION, HttpHeaders.encodeBasicAuth(user, pass, StandardCharsets.UTF_8))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(TestData.getClienteAltaRequest())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", Matchers.notNullValue()));
    }

    @Test
    @WithMockUser(roles = "USER")
    void actualizarCliente() throws Exception {
        Mockito.when(clienteService.actualizarEstado(ArgumentMatchers.any(ClienteUpdateRequest.class)))
                .thenReturn(TestData.getClienteResponse());

        mockMvc.perform(MockMvcRequestBuilders.patch("/clientes")
                        .header(HttpHeaders.AUTHORIZATION, HttpHeaders.encodeBasicAuth(user, pass, StandardCharsets.UTF_8))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(TestData.getClienteUpdateRequest())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.notNullValue()));
    }

    @Test
    @WithMockUser(roles = "USER")
    void consultarCliente() throws Exception {
        Mockito.when(clienteService.consultarCliente(ArgumentMatchers.any(Long.class)))
                .thenReturn(TestData.getClienteResponse());

        mockMvc.perform(MockMvcRequestBuilders.get("/clientes/1")
                        .header(HttpHeaders.AUTHORIZATION, HttpHeaders.encodeBasicAuth(user, pass, StandardCharsets.UTF_8)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.notNullValue()));

    }
}