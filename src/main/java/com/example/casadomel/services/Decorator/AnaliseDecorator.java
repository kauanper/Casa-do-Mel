package com.example.casadomel.services.Decorator;

import com.example.casadomel.entities.Apicultor;
import com.example.casadomel.entities.ServicosOferecido;

public class AnaliseDecorator extends ServicoDecorator{
    public AnaliseDecorator(ServicosOferecido servicosOferecido) {
        super(servicosOferecido);
    }

    @Override
    public void calcularCusto(double mel, Apicultor apicultor) {
        super.calcularCusto(mel, apicultor);
        apicultor.setValorReceber(apicultor.getValorReceber() + mel * 1);
        System.out.println("Analise aplicado: R$ " + (mel * 1));
    }
}
