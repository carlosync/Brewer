package com.brewer.model;


public enum Sabor {

    ADOCICADA("Adocicada"),
    AMARGA("Amarga"),
    FORTE("Forte"),
    FRUTA("Fruta"),
    SUAVE("Suave");

    private String descricao;

    Sabor(String descicao) {
        this.descricao = descicao;
    }

    public String getDescricao() {
        return descricao;
    }
}
