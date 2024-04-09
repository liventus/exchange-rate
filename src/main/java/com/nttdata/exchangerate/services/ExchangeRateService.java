package com.nttdata.exchangerate.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.exchangerate.dto.Memory;
import com.nttdata.exchangerate.dto.ModelExternResponsePair;
import com.nttdata.exchangerate.dto.ResponsePostConsulting;
import com.nttdata.exchangerate.dto.ValorMemory;
import com.nttdata.exchangerate.infraestructura.ApiClient;
import com.nttdata.exchangerate.model.ExchangeRate;
import com.nttdata.exchangerate.repositoryMemory.ObjetRepositoryMemory;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.*;


@Service
public class ExchangeRateService {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Autowired
  private ObjetRepositoryMemory objetRepository;

  @Autowired
  public ApiClient apiClientw;

  public void saveExchangeRate(ValorMemory valorMemory) {
    Memory memory = new Memory();
    memory.setClave(valorMemory.getBaseCode());
    memory.setValor(valorMemory.toString());
    objetRepository.save(memory);
  }

  public List<Memory> getAllMemory() {


    return objetRepository.findAll();
  }


  public Object getDataCurrencyString(String exchangeRate) {
    System.out.println("1");
    return apiClientw.getConversionsAll(exchangeRate);
  }

  public ResponsePostConsulting getDataCurrencyAndSave(ExchangeRate exchangeRate) {
    System.out.println("1");
    String ValueCodeH2 = exchangeRate.getFromCurrency().getCode()
        + "/" + exchangeRate.getToCurrency().getCode()
        + "/" + exchangeRate.getAmount();
    Date date = new Date();
    long unixTimestamp = date.getTime();
    Optional<Memory> optionalMemory = objetRepository.findById(ValueCodeH2);
    if (optionalMemory.isEmpty()) {
      ModelExternResponsePair responseApi = converterJsonDto(apiClientw.getConversionsPars(exchangeRate.getFromCurrency().getCode(), exchangeRate.getToCurrency().getCode(), exchangeRate.getAmount()));
      Memory memory = new Memory();
      memory.setValor(responseApi.toString());
      memory.setClave(ValueCodeH2);
      objetRepository.save(memory);
      ResponsePostConsulting responsePostConsulting = new ResponsePostConsulting();
      responsePostConsulting.setStatus(HttpHeaders.ACCEPT);
      responsePostConsulting.setDescription("consulta nueva exitosa");
      responsePostConsulting.setDetail(responseApi);
      return responsePostConsulting;
    } else {
      ResponsePostConsulting responsePostConsulting2 = new ResponsePostConsulting();
      responsePostConsulting2.setStatus(HttpHeaders.ACCEPT);
      responsePostConsulting2.setDescription("consulta ya existe, y se extraido de la memoria");
      Memory memory = optionalMemory.get();
      System.out.println(memory);
      System.out.println(memory.getValor());
      try {
        ModelExternResponsePair value = convertJsonToDto(memory.getValor());
        responsePostConsulting2.setDetail(value);
        return responsePostConsulting2;
      } catch (Exception e) {
        System.out.println("Error al deserializar el mapa: " + e.getMessage());
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
      System.out.println("-----------------");
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

