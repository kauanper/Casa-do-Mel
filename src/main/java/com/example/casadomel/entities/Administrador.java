package com.example.casadomel.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class Administrador {
    private String nome;
    private String email;
    private String senha;
    private boolean superAdmin;
}
