package com.projeto.ads.enums;

public enum Periodo {
    PRIMEIRO("1"),
    SEGUNDO("2"),
    TERCEIRO("3"),
    QUARTO("4");

    private String periodo;

    private Periodo (String periodo) {
        this.periodo = periodo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
