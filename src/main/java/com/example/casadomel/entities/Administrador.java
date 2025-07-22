package com.example.casadomel.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Administrador extends Usuario {
    private boolean superAdmin;
}
