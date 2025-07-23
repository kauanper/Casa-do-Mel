package com.example.casadomel.services.Decorator;

import com.example.casadomel.entities.Apicultor;
import com.example.casadomel.entities.ServicosOferecido;

public class EnvaseDecorator extends ServicoDecorator{
    public EnvaseDecorator(ServicosOferecido servico) {
        super(servico);
    }

    @Override
    public void calcularCusto(double mel, Apicultor apicultor) {
        super.calcularCusto(mel, apicultor);
        apicultor.setValorReceber(apicultor.getValorReceber() + mel * 3.5);
        System.out.println("Envase aplicado: R$ " + (mel * 3.5));
    }
}
