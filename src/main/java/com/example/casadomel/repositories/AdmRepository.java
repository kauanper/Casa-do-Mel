package com.example.casadomel.repositories;

import com.example.casadomel.entities.Administrador;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AdmRepository {
    private final List<Administrador> administradores = new ArrayList<>();

    public AdmRepository() {
        Administrador admin1 = new Administrador();
        admin1.setNome("Jose");
        admin1.setEmail("admin@casamel.com");
        admin1.setSenha("123456");
        admin1.setSuperAdmin(true);

        administradores.add(admin1);
    }

    public Administrador buscarPorNome(String nome) {
        for (Administrador administrador : administradores) {
            if (administrador.getNome().equals(nome)) {
                return administrador;
            }
        }
        return null;
    }
}
