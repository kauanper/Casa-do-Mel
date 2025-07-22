package com.example.casadomel.repositories;

import com.example.casadomel.entities.Administrador;
import com.example.casadomel.entities.Apicultor;
import com.example.casadomel.entities.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuariosRepository {
    private List<Usuario> usuarios;


    public List<Usuario> listarTodos() {
        return usuarios;
    }

    public void adicionar(Usuario usuario) {
        usuarios.add(usuario);
    }
}
