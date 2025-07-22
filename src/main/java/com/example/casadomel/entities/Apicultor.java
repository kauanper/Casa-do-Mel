package com.example.casadomel.entities;

public class Apicultor {
    private String nome;
    private String email;
    private String senha;
    private int quantidadeColmeias;
    private double valorReceber;
    private double quantidadeMel_kg;
    private boolean pago;

    // Getters
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getQuantidadeColmeias() {
        return quantidadeColmeias;
    }

    public double getValorReceber() {
        return valorReceber;
    }

    public double getQuantidadeMel_kg() {
        return quantidadeMel_kg;
    }

    public boolean isPago() {
        return pago;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setQuantidadeColmeias(int quantidadeColmeias) {
        this.quantidadeColmeias = quantidadeColmeias;
    }

    public void setValorReceber(double valorReceber) {
        this.valorReceber = valorReceber;
    }

    public void setQuantidadeMel_kg(double quantidadeMel_kg) {
        this.quantidadeMel_kg = quantidadeMel_kg;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
}
