package com.example.casadomel.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

    public Usuario() {}

    protected String nome;
    protected String email;
    protected String senha;
}
