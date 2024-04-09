package com.nttdata.exchangerate.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.exchangerate.dto.Memory;
import com.nttdata.exchangerate.dto.ModelExternResponsePair;
import com.nttdata.exchangerate.dto.ResponsePostConsulting;
import com.nttdata.exchangerate.dto.ValorMemory;
import com.nttdata.exchangerate.infraestructura.ApiClient;
import com.nttdata.exchangerate.model.ExchangeRate;
import com.nttdata.exchangerate.repositoryMemory.ObjetRepositoryMemory;
import com.nttdata.exchangerate.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;


import java.util.*;


@Service
public class ExchangeRateService {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Autowired
  private ObjetRepositoryMemory objetRepository;

  @Autowired
  public ApiClient apiClient;

  public void saveExchangeRate(ValorMemory valorMemory) {
    Memory memory = Memory.builder().clave(valorMemory.getBaseCode()).valor(valorMemory.toString()).build();
    objetRepository.save(memory);
  }

  public List<Memory> getAllMemory() {
    return objetRepository.findAll();
  }


  public Object getDataCurrencyString(String exchangeRate) {
    return apiClient.getConversionsAll(exchangeRate);
  }

  public ResponsePostConsulting getDataCurrencyAndSave(ExchangeRate exchangeRate) {
    String ValueCodeH2 = exchangeRate.getFromCurrency().getCode()
        + Constants.CONCAT_CLAVE + exchangeRate.getToCurrency().getCode()
        + Constants.CONCAT_CLAVE + exchangeRate.getAmount();
    Optional<Memory> optionalMemory = objetRepository.findById(ValueCodeH2);
    if (optionalMemory.isEmpty()) {
      ModelExternResponsePair responseApi = converterJsonDto(apiClient.getConversionsPars(exchangeRate.getFromCurrency().getCode(), exchangeRate.getToCurrency().getCode(), exchangeRate.getAmount()));
      Memory memory = Memory.builder().valor(responseApi.toString()).clave(ValueCodeH2).build();
      objetRepository.save(memory);
      return ResponsePostConsulting
          .builder()
          .status(HttpHeaders.ACCEPT)
          .description(Constants.MESSAGE_NUEVO)
          .detail(responseApi)
          .build();
    } else {
      ResponsePostConsulting responsePostConsulting2 = new ResponsePostConsulting();
      responsePostConsulting2.setStatus(HttpHeaders.ACCEPT);
      responsePostConsulting2.setDescription(Constants.MESSAGE_MEMORIA);
      Memory memory = optionalMemory.get();

      try {
        ModelExternResponsePair value = convertJsonToDto(memory.getValor());
        responsePostConsulting2.setDetail(value);
        return responsePostConsulting2;
      } catch (Exception e) {
        System.out.println(Constants.ERROR_MAPA + e.getMessage());
      }
      return responsePostConsulting2;
    }
  }

  private ModelExternResponsePair converterJsonDto(Object objectFeign) {
    try {
      if (objectFeign != null) {
        String json = objectMapper.writeValueAsString(objectFeign);
        return objectMapper.readValue(json, ModelExternResponsePair.class);
      } else {
        return null;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  private ModelExternResponsePair convertJsonToDto(String jsonString) {
    try {
      if (jsonString != null && !jsonString.isEmpty()) {
        return objectMapper.readValue(jsonString, ModelExternResponsePair.class);
      } else {
        return null;
      }
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      return null;
    }
  }

}

