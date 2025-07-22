package com.example.casadomel.repositories;

import com.example.casadomel.entities.Administrador;
import org.springframework.stereotype.Repository;

@Repository
public class AdmRepository {
    private Administrador adm;

    public AdmRepository() {
        Administrador admin1 = new Administrador();
        admin1.setNome("Jose");
        admin1.setEmail("admin@casamel.com");
        admin1.setSenha("123456");
        admin1.setSuperAdmin(true);
        this.adm = admin1;
    }

    public Administrador validarLogin(String email, String senha) {

        if(email.equals(adm.getEmail())) {
            if(senha.equals(adm.getSenha())) {
                return adm;
            }else {
                return null; //senha inconrreta
            }
        }else {
            return null; //email inconrreto
        }
    }
}
