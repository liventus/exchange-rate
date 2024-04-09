package com.nttdata.exchangerate.infraestructura;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "CURRENCY", url = "${api.backend.url.base}",configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface ApiClient {

  String urlAll = "${api.backend.url}";
  String urlPair = "${api.backend.url.pair}";

  @GetMapping(value = urlAll,consumes = MediaType.APPLICATION_JSON_VALUE)
  Object getConversionsAll(@PathVariable("currency") String currency);

  @GetMapping(value = urlPair,consumes = MediaType.APPLICATION_JSON_VALUE)
  Object getConversionsPars(@PathVariable("currency") String currency, @PathVariable("target") String target, @PathVariable("amount") BigDecimal amount );

}
