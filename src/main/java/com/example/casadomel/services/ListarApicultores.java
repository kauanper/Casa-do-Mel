package com.example.casadomel.services;

import com.example.casadomel.entities.Apicultor;
import com.example.casadomel.repositories.ApicultorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListarApicultores {

    @Autowired
    ApicultorRepository apicultorRepository;

    public List<Apicultor> execute(){

        List<Apicultor> apicultores = apicultorRepository.listarTodos();

        return apicultores;
    }
}
