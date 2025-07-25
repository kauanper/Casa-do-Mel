package com.example.casadomel.services;

import com.example.casadomel.entities.Administrador;
import com.example.casadomel.entities.Apicultor;
import com.example.casadomel.repositories.AdmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<String> listarApicultorsPorNome() {
        List<String> nomes = new ArrayList<>();
        List<Apicultor> apicultorList = apicultorService.todosApicultores();
        for (Apicultor apicultor : apicultorList) {
            nomes.add(apicultor.getNome());
        }
        return nomes;
    }

    public Apicultor alterarMel(String nome, Double valor) {
        Apicultor ap = apicultorService.buscarPorNome(nome);
        if (ap == null) {
            System.out.println("não achado");
            return null; //apicultor não achado
        }
        if(ap.isPago() == false) {
            System.out.println("é isso kauan");
            return null;//operação invalida, pois está devendo
        }
        ap.setQuantidadeMel_kg(ap.getQuantidadeMel_kg() + valor);

        return ap;
    }

    public Apicultor atualizarPagamento(String nome){
        Apicultor ap = apicultorService.buscarPorNome(nome);
        if (ap == null) {
            return null;
        }
        if(ap.isPago()){
            return ap;
        }
        ap.setPago(true);
        ap.setValorReceber(0);
        ap.setQuantidadeMel_kg(0);
        return ap;
    }

    public List<Apicultor> buscarTodos() {
        return apicultorService.todosApicultores();
    }


}
