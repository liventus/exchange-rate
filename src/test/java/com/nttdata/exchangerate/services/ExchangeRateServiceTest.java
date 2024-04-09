package com.nttdata.exchangerate.services;

import com.nttdata.exchangerate.dto.Memory;
import com.nttdata.exchangerate.dto.ModelExternResponsePair;
import com.nttdata.exchangerate.dto.ResponsePostConsulting;
import com.nttdata.exchangerate.dto.ValorMemory;
import com.nttdata.exchangerate.infraestructura.ApiClient;
import com.nttdata.exchangerate.model.Currency;
import com.nttdata.exchangerate.model.ExchangeRate;
import com.nttdata.exchangerate.repositoryMemory.ObjetRepositoryMemory;
import com.nttdata.exchangerate.services.ExchangeRateService;
import com.nttdata.exchangerate.util.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExchangeRateServiceTest {

  @Mock
  private ObjetRepositoryMemory objetRepository;

  @Mock
  private ApiClient apiClient;

  @InjectMocks
  private ExchangeRateService exchangeRateService;

  @Test
  public void saveExchangeRateTest() {
    ValorMemory valorMemory = new ValorMemory(/* valores de prueba */);
    exchangeRateService.saveExchangeRate(valorMemory);
    verify(objetRepository).save(any(Memory.class));
  }

  @Test
  public void getAllMemoryTest() {
    List<Memory> expectedMemoryList = Arrays.asList(new Memory(/* datos de prueba */));
    when(objetRepository.findAll()).thenReturn(expectedMemoryList);
    List<Memory> result = exchangeRateService.getAllMemory();
    assertEquals(expectedMemoryList, result);
  }

  @Test
  public void getDataCurrencyAndSaveTest() {
    Optional<Memory> optionalMemory = Optional.empty();
    when(objetRepository.findById(anyString())).thenReturn(optionalMemory);
    ModelExternResponsePair expectedResponse = new ModelExternResponsePair(/* datos de prueba */);
    when(apiClient.getConversionsPars(anyString(), anyString(), any())).thenReturn(expectedResponse);
    ExchangeRate exchangeRate = ExchangeRate
        .builder()
        .toCurrency(Currency.builder().code("USD")
            .build()).fromCurrency(Currency.builder()
            .code("USD").build()).amount(new BigDecimal(1.2))
        .build();
    ResponsePostConsulting result = exchangeRateService.getDataCurrencyAndSave(exchangeRate);

    assertEquals(HttpHeaders.ACCEPT, result.getStatus());
    assertEquals(Constants.MESSAGE_NUEVO, result.getDescription());
    assertEquals(expectedResponse, result.getDetail());
  }
}
