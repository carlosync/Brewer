package com.brewer.model;


public enum Sabor {

    ADOCICADA("Adocicada"),
    AMARGA("Amarga"),
    FORTE("Forte"),
    FRUTA("FRUTA"),
    SUAVE("Suave");

    private String descicao;

    Sabor(String descicao) {
        this.descicao = descicao;
    }

    public String getDescicao() {
        return descicao;
    }
}
