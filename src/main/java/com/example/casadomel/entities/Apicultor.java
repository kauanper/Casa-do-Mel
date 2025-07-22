package com.example.casadomel.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Apicultor extends Usuario {
    private int quantidadeColmeias;
    private double valorReceber;
    private double quantidadeMel_kg;
    private boolean pago;
}
