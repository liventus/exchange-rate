package com.nttdata.exchangerate.controller;

import com.nttdata.exchangerate.dto.Memory;
import com.nttdata.exchangerate.dto.ValorMemory;
import com.nttdata.exchangerate.services.ExchangeRateService;
import com.nttdata.exchangerate.util.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ExchangeRateControllerTest {
  @Mock
  private ExchangeRateService exchangeRateService;

  @InjectMocks
  private ExchangeRateController controller;

  private MockMvc mockMvc;

  @Test
  public void guardarObjetoTest() throws Exception {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    String jsonRequest = "{\"propiedad1\": \"valor1\", \"propiedad2\": \"valor2\"}";
    mockMvc.perform(post(Constants.POST_OBJETOS)
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonRequest))
        .andExpect(status().isOk())
        .andExpect(content().string(Constants.MESSAGE_RESPONSE_ONE));
    verify(exchangeRateService).saveExchangeRate(any(ValorMemory.class));
  }


  @Test
  public void getAllUsersTest() {
    List<Memory> memoryList = Arrays.asList(new Memory());
    when(exchangeRateService.getAllMemory()).thenReturn(memoryList);
    List<Memory> result = controller.getAllUsers();
    assertEquals(memoryList, result);
  }

}