package com.nttdata.exchangerate.controller;


import com.nttdata.exchangerate.dto.*;
import com.nttdata.exchangerate.model.Currency;
import com.nttdata.exchangerate.model.ExchangeRate;
import com.nttdata.exchangerate.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController


public class ExchangeRateController {
    @Autowired
    private ExchangeRateService exchangeRateService;

    @PostMapping("/objetos")
    public String guardarObjeto(@RequestBody ValorMemory memory) {

        exchangeRateService.saveExchangeRate(memory);
        return "Objeto guardado correctamente";
    }

    @GetMapping("/list-objetos")
    public List<Memory> getAllUsers(){
        return exchangeRateService.getAllMemory();
    }


    @GetMapping("/api-extern")
    public Object getApiExerns(){

        return exchangeRateService.getDataCurrencyString("USD");
    }

    @PostMapping("/exchange-rate")
    public ResponsePostConsulting getApiExernsExchange(
        @RequestBody ExchangeRate request){
        System.out.println("request: "+ request);
        return exchangeRateService.getDataCurrencyAndSave(request);
    }



}