package com.nttdata.exchangerate.controller;


import com.nttdata.exchangerate.dto.Memory;
import com.nttdata.exchangerate.dto.ModelExternResponse;
import com.nttdata.exchangerate.dto.ValorMemory;
import com.nttdata.exchangerate.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}