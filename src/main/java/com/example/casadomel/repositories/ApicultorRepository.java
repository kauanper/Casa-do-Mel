package com.example.casadomel.repositories;

import com.example.casadomel.entities.Apicultor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ApicultorRepository {
    private final List<Apicultor> apicultores = new ArrayList<>();

    public ApicultorRepository() {
        Apicultor a1 = new Apicultor();
        a1.setNome("Kauan");
        a1.setEmail("kauan@mel.com");
        a1.setSenha("123456");
        a1.setQuantidadeColmeias(10);
        a1.setValorReceber(500.0);
        a1.setQuantidadeMel_kg(45.0);
        a1.setPago(false);

        Apicultor a2 = new Apicultor();
        a2.setNome("vitoria");
        a2.setEmail("vitoria@mel.com");
        a2.setSenha("123456");
        a2.setQuantidadeColmeias(15);
        a2.setValorReceber(800.0);
        a2.setQuantidadeMel_kg(70.5);
        a2.setPago(true);

        apicultores.add(a1);
        apicultores.add(a2);
    }

    public List<Apicultor> listarTodos() {
        return Collections.unmodifiableList(apicultores);
    }

    public void adicionar(Apicultor apicultor) {
        apicultores.add(apicultor);
    }
}
