package com.example.casadomel.services;

import com.example.casadomel.entities.Administrador;
import com.example.casadomel.entities.Apicultor;
import com.example.casadomel.repositories.AdmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmSercive {

    @Autowired
    private AdmRepository admRepository;

    @Autowired
    private ApicultorService apicultorService;

    public List<Apicultor> admLogin(String email, String senha) {
        Administrador admin = admRepository.validarLogin(email, senha);
        if (admin == null) {
            return null;
        }

        return apicultorService.todosApicultores();
    }
}
