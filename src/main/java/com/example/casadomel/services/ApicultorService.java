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
        System.out.println("ok");
    }
}
