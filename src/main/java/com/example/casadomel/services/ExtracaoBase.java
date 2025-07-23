package com.example.casadomel.services;

import com.example.casadomel.entities.Apicultor;
import com.example.casadomel.entities.ServicosOferecido;
import org.springframework.stereotype.Service;

@Service
public class ExtracaoBase implements ServicosOferecido {

    @Override
    public void calcularCusto(double mel_kg, Apicultor apicultor) {
        apicultor.setValorReceber(apicultor.getValorReceber() + mel_kg * 2.0);
        System.out.println("Valor receber: " + apicultor.getValorReceber());
    }
}
