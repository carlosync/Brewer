package com.brewer.model;


public enum Origem {

    NACIONAL("Nacional"),
    INTERNACIONAL("Internacional");

    private String descricao;

    Origem(String descicao) {
        this.descricao = descicao;
    }

    public String getDescricao() {
        return descricao;
    }
}
