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
        a1.setNome("Ana");
        a1.setEmail("ana@mel.com");
        a1.setSenha("123456");
        a1.setQuantidadeColmeias(0);
        a1.setValorReceber(0.0);
        a1.setQuantidadeMel_kg(30.3);
        a1.setPago(false);

        Apicultor a2 = new Apicultor();
        a2.setNome("Vitoria");
        a2.setEmail("vitoria@mel.com");
        a2.setSenha("123456");
        a2.setQuantidadeColmeias(150);
        a2.setValorReceber(800.0);
        a2.setQuantidadeMel_kg(70.5);
        a2.setPago(false);

        Apicultor a3 = new Apicultor();
        a3.setNome("Francisco");
        a3.setEmail("francisco@mel.com");
        a3.setSenha("123456");
        a3.setQuantidadeColmeias(8);
        a3.setValorReceber(320.0);
        a3.setQuantidadeMel_kg(20.0);
        a3.setPago(false);

        Apicultor a4 = new Apicultor();
        a4.setNome("Kauan");
        a4.setEmail("kauan@mel.com");
        a4.setSenha("123456");
        a4.setQuantidadeColmeias(12);
        a4.setValorReceber(600.0);
        a4.setQuantidadeMel_kg(50.0);
        a4.setPago(false);

        Apicultor a5 = new Apicultor();
        a5.setNome("Maria");
        a5.setEmail("maria@mel.com");
        a5.setSenha("123456");
        a5.setQuantidadeColmeias(6);
        a5.setValorReceber(150.0);
        a5.setQuantidadeMel_kg(12.0);
        a5.setPago(false);

        Apicultor a6 = new Apicultor();
        a6.setNome("Sophia");
        a6.setEmail("sophia@mel.com");
        a6.setSenha("123456");
        a6.setQuantidadeColmeias(18);
        a6.setValorReceber(910.0);
        a6.setQuantidadeMel_kg(80.0);
        a6.setPago(false);

        Apicultor a7 = new Apicultor();
        a7.setNome("Daniel");
        a7.setEmail("daniel@mel.com");
        a7.setSenha("123456");
        a7.setQuantidadeColmeias(7);
        a7.setValorReceber(200.0);
        a7.setQuantidadeMel_kg(17.3);
        a7.setPago(false);

        Apicultor a8 = new Apicultor();
        a8.setNome("Lucas");
        a8.setEmail("lucas@mel.com");
        a8.setSenha("123456");
        a8.setQuantidadeColmeias(20);
        a8.setValorReceber(1050.0);
        a8.setQuantidadeMel_kg(90.0);
        a8.setPago(false);

        apicultores.add(a1);
        apicultores.add(a2);
        apicultores.add(a3);
        apicultores.add(a4);
        apicultores.add(a5);
        apicultores.add(a6);
        apicultores.add(a7);
        apicultores.add(a8);
    }

    public List<Apicultor> listarTodos() {
        return Collections.unmodifiableList(apicultores);
    }

    public void adicionar(Apicultor apicultor) {
        apicultores.add(apicultor);
    }

    public Apicultor buscarPorNome(String nome) {
        for (Apicultor apicultor : apicultores) {
            if (apicultor.getNome().equals(nome)) {
                return apicultor;
            }
        }
        return null;
    }
}
