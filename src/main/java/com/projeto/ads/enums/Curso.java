package com.projeto.ads.enums;

public enum Curso {
    MARKETING("MARKETING"),
    ADMINISTRACAO("ADMINISTRAÇÂO"),
    ADS("ADS"),
    CONTABILIDADE("CONTABILIDADE"),
    ENFERMAGEM("ENFERMAGEM");

    private final String nome;

    Curso(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
