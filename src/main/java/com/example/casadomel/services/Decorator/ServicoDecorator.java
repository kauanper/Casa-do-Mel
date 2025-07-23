package com.example.casadomel.services.Decorator;

import com.example.casadomel.entities.Apicultor;
import com.example.casadomel.entities.ServicosOferecido;

public abstract class ServicoDecorator implements ServicosOferecido {
    protected ServicosOferecido servicosOferecido;

    public ServicoDecorator(ServicosOferecido servicosOferecido) {
        this.servicosOferecido = servicosOferecido;
    }

    @Override
    public void calcularCusto(double mel, Apicultor apicultor) {
        servicosOferecido.calcularCusto(mel, apicultor); //chamar servico anterior
    }
}
