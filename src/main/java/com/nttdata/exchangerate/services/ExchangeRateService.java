package com.nttdata.exchangerate.services;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.exchangerate.dto.Memory;
import com.nttdata.exchangerate.dto.ResponsePostConsulting;
import com.nttdata.exchangerate.dto.ValorMemory;
import com.nttdata.exchangerate.infraestructura.ApiClient;
import com.nttdata.exchangerate.model.ExchangeRate;
import com.nttdata.exchangerate.repositoryMemory.ObjetRepositoryMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class ExchangeRateService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private ObjetRepositoryMemory objetRepository;

    @Autowired
    public ApiClient apiClientw;

    public void saveExchangeRate(ValorMemory valorMemory) {
        Memory memory = new Memory();
        memory.setClave(valorMemory.getBaseCode()); memory.setValor(valorMemory.toString());
        objetRepository.save(memory);
    }

    public List<Memory> getAllMemory(){


        return objetRepository.findAll();
    }


    public Object getDataCurrencyString(String exchangeRate) {
        System.out.println("1");
        return apiClientw.getConversionsAll(exchangeRate);
    }

    public ResponsePostConsulting getDataCurrencyAndSave(ExchangeRate exchangeRate) {
        System.out.println("1");
        String ValueCodeH2  = exchangeRate.getFromCurrency().getCode()+"/"+exchangeRate.getToCurrency().getCode();

        Optional<Memory> optionalMemory = objetRepository.findById(ValueCodeH2);
        if(optionalMemory.isEmpty()){

            Object resultExtern =  apiClientw.getConversionsPars(exchangeRate.getFromCurrency().getCode(),exchangeRate.getToCurrency().getCode(),exchangeRate.getAmount());
            System.out.println(resultExtern);
            Memory memory = new Memory();
            Map<String, Object> resultMap = (Map<String, Object>) resultExtern;

            memory.setClave(ValueCodeH2);
            memory.setValor(resultMap.toString());
            objetRepository.save(memory);

            ResponsePostConsulting responsePostConsulting = new ResponsePostConsulting();
            responsePostConsulting.setStatus(HttpHeaders.ACCEPT);
            responsePostConsulting.setDescription("consulta nueva exitosa");
            responsePostConsulting.setDetail(resultMap);
            return responsePostConsulting;

        } else {
            ResponsePostConsulting responsePostConsulting2 = new ResponsePostConsulting();
            responsePostConsulting2.setStatus(HttpHeaders.ACCEPT);
            responsePostConsulting2.setDescription("consulta ya existe, y se extraido de la memoria");
            System.out.println("----------------");
            Memory memory = optionalMemory.get();
            System.out.println("----------------");
            System.out.println(memory);
            String valorString = memory.getValor();
            System.out.println(valorString);
            System.out.println("----------------");
            try {
                Map<String, Object> valorMap = objectMapper.readValue(valorString, new TypeReference<Map<String, Object>>(){});

                responsePostConsulting2.setDetail(valorMap);

                System.out.println("Mapa deserializado: " + valorMap);
                return responsePostConsulting2;
            } catch (IOException e) {

                System.out.println("Error al deserializar el mapa: " + e.getMessage());
            }



            return responsePostConsulting2;
        }






    }



}