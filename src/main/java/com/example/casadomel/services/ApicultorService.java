package com.example.casadomel.services;

import com.example.casadomel.entities.Apicultor;
import com.example.casadomel.repositories.ApicultorRepository;
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
}
