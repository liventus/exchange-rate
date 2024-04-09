package com.nttdata.exchangerate.controller;


import com.nttdata.exchangerate.dto.*;
import com.nttdata.exchangerate.model.Currency;
import com.nttdata.exchangerate.model.ExchangeRate;
import com.nttdata.exchangerate.services.ExchangeRateService;
import com.nttdata.exchangerate.util.Constants;
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

    @PostMapping(Constants.POST_OBJETOS)
    public String guardarObjeto(@RequestBody ValorMemory memory) {
        exchangeRateService.saveExchangeRate(memory);
        return Constants.MESSAGE_RESPONSE_ONE;
    }

    @GetMapping(Constants.GET_OBJETOS_LIST)
    public List<Memory> getAllUsers(){
        return exchangeRateService.getAllMemory();
    }


    @GetMapping(Constants.GET_OBJETOS_API_EXTERN)
    public Object getApiExerns(){
        return exchangeRateService.getDataCurrencyString(Constants.MESSAGE_RESPONSE_EXAMPLE);
    }

    @PostMapping(Constants.POST_EXCHANGE)
    public ResponsePostConsulting getApiExernsExchange(
        @RequestBody ExchangeRate request){
        return exchangeRateService.getDataCurrencyAndSave(request);
    }



}