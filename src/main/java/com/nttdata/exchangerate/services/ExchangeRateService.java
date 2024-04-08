package com.nttdata.exchangerate.services;

import com.nttdata.exchangerate.dto.Memory;
import com.nttdata.exchangerate.dto.ModelExternResponse;
import com.nttdata.exchangerate.dto.ValorMemory;
import com.nttdata.exchangerate.repositoryMemory.ObjetRepositoryMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExchangeRateService {

    @Autowired
    private ObjetRepositoryMemory objetRepository;

    public void saveExchangeRate(ValorMemory valorMemory) {
        Memory memory = new Memory();
        memory.setClave(valorMemory.getBaseCode()); memory.setValor(valorMemory.toString());
        objetRepository.save(memory);
    }

    public List<Memory> getAllMemory(){


        return objetRepository.findAll();
    }
}