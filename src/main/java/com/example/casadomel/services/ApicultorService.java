package com.example.casadomel.services;

import com.example.casadomel.entities.Apicultor;
import com.example.casadomel.entities.ServicosOferecido;
import com.example.casadomel.repositories.ApicultorRepository;
import com.example.casadomel.services.Decorator.AnaliseDecorator;
import com.example.casadomel.services.Decorator.CeraDecorator;
import com.example.casadomel.services.Decorator.EnvaseDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApicultorService {

    @Autowired
    ApicultorRepository apicultorRepository;

    public List<Apicultor> todosApicultores() {
        return apicultorRepository.listarTodos();
    }

    public void adicionarApicultor(String nome, String email, String senha) {
        Apicultor apicultor = new Apicultor();
        apicultor.setNome(nome);
        apicultor.setEmail(email);
        apicultor.setSenha(senha);
        apicultor.setQuantidadeColmeias(0);
        apicultor.setQuantidadeMel_kg(0.0);
        apicultor.setValorReceber(0.0);
        apicultor.setPago(false);
        apicultorRepository.adicionar(apicultor);
    }

    public Apicultor login(String email, String senha) {
        List<Apicultor> apicultors = apicultorRepository.listarTodos();
        for (Apicultor apicultor : apicultors) {
            if(apicultor.getEmail().equals(email) && apicultor.getSenha().equals(senha)) {
                return apicultor;
            }
        }
        return null;
    }

    public Apicultor adicionarColmeia(String nome, int valor) {
        Apicultor apicultor = apicultorRepository.buscarPorNome(nome);
        if(apicultor == null) {
            return null;
        }
        apicultor.setQuantidadeColmeias(apicultor.getQuantidadeColmeias() + valor);
        return apicultor;
    }

    public Apicultor removerColmeia(String nome, int valor) {
        Apicultor apicultor = apicultorRepository.buscarPorNome(nome);
        if(apicultor == null) {
            return null;
        }
        apicultor.setQuantidadeColmeias(apicultor.getQuantidadeColmeias() - valor);
        if(apicultor.getQuantidadeColmeias() < 0) {
            apicultor.setQuantidadeColmeias(0);
        }
        return apicultor;
    }

    public Apicultor buscarPorNome(String nome) {
        Apicultor apicultor = apicultorRepository.buscarPorNome(nome);
        if(apicultor == null) {
            return null;
        }
        return apicultor;
    }

    public Double calcularPorServico(String nome, String servico) {
        Apicultor apicultor = apicultorRepository.buscarPorNome(nome);
        if (apicultor == null) {
            return null;
        }
        if(apicultor.isPago() == false) {
            return null;
        }

        double quantidadeMel = apicultor.getQuantidadeMel_kg();

        // Serviço base: extração
        ServicosOferecido servicoDecorator = new ExtracaoBase();

        // Verifica se o parâmetro "servico" inclui outras opções
        if (servico.contains("1")) { //envase
            servicoDecorator = new EnvaseDecorator(servicoDecorator);
        }
        if (servico.contains("2")) { // cera
            servicoDecorator = new CeraDecorator(servicoDecorator);
        }
        if (servico.contains("3")) { // analise
            servicoDecorator = new AnaliseDecorator(servicoDecorator);
        }

        servicoDecorator.calcularCusto(quantidadeMel, apicultor);
        if(apicultor.getValorReceber() != 0){
            apicultor.setPago(false);
        }

        return apicultor.getValorReceber();
    }

}
