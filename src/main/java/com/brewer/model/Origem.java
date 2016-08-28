package com.brewer.model;


public enum Origem {

    NACIONAL("Nacional"),
    INTERNACIONAL("Internacional");

    private String descicao;

    Origem(String descicao) {
        this.descicao = descicao;
    }

    public String getDescicao() {
        return descicao;
    }
}
