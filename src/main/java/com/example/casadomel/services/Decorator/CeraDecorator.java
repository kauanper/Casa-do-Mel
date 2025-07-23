package com.example.casadomel.services.Decorator;

import com.example.casadomel.entities.Apicultor;
import com.example.casadomel.entities.ServicosOferecido;

public class CeraDecorator extends ServicoDecorator{
    public CeraDecorator(ServicosOferecido servico) {
        super(servico);
    }

    @Override
    public void calcularCusto(double mel, Apicultor apicultor) {
        super.calcularCusto(mel, apicultor);
        apicultor.setValorReceber(apicultor.getValorReceber() + mel * 0.5);
        System.out.println("Cera aplicado: R$ " + (mel * 0.5));
    }
}
