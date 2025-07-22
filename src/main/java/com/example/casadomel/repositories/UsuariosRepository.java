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

    public UsuariosRepository() {
        usuarios = new ArrayList<>();

        Apicultor apicultor1 = new Apicultor();
        apicultor1.setNome("Kauan");
        apicultor1.setEmail("kauan@email.com");
        apicultor1.setSenha("123");
        apicultor1.setQuantidadeColmeias(5);
        apicultor1.setPago(false);

        Apicultor apicultor2 = new Apicultor();
        apicultor2.setNome("Vitoria");
        apicultor2.setEmail("vitoria@email.com");
        apicultor2.setSenha("abc");
        apicultor2.setQuantidadeColmeias(3);
        apicultor2.setPago(false);

        Administrador admin = new Administrador();
        admin.setNome("Admin");
        admin.setEmail("admin@email.com");
        admin.setSenha("admin123");
        admin.setSuperAdmin(false);

        usuarios.add(apicultor1);
        usuarios.add(apicultor2);
        usuarios.add(admin);
    }

    public List<Usuario> listarTodos() {
        return usuarios;
    }

    public void adicionar(Usuario usuario) {
        usuarios.add(usuario);
    }
}
