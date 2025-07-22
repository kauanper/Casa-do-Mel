package com.example.casadomel.entities;

import lombok.Data;

@Data
public class Apicultor {
    private String nome;
    private String email;
    private String senha;
    private int quantidade_colmeias;
    private double valor_pagamento;
    private double quantidade_mel_kg;
    private boolean pago;
}
