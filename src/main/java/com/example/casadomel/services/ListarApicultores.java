package com.example.casadomel.services;

import com.example.casadomel.entities.Apicultor;
import com.example.casadomel.entities.Usuario;
import com.example.casadomel.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListarApicultores {

    @Autowired
    UsuariosRepository usuariosRepository;

    public List<Apicultor> execute(){

        List<Usuario> usuarios = usuariosRepository.listarTodos();
        List<Apicultor> apicultores = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            if(usuario instanceof Apicultor){
                apicultores.add((Apicultor) usuario);
            }
        }
        return apicultores;
    }
}
