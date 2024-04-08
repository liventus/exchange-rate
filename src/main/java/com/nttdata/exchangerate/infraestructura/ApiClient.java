package com.nttdata.exchangerate.infraestructura;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "CURRENCY", url = "https://v6.exchangerate-api.com",configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface ApiClient {

  String urlAll = "v6/dfa0da5d49361df81053ab7b/latest/{currency}";
  String urlPair = "v6/dfa0da5d49361df81053ab7b/pair/{currency}/{target}/{amount}";

  @GetMapping(value = urlAll,consumes = MediaType.APPLICATION_JSON_VALUE)
  Object getConversionsAll(@PathVariable("currency") String currency);

  @GetMapping(value = urlPair,consumes = MediaType.APPLICATION_JSON_VALUE)
  Object getConversionsPars(@PathVariable("currency") String currency, @PathVariable("target") String target, @PathVariable("amount") BigDecimal amount );

}
