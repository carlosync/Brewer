package com.brewer.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "estilo")
public class Estilo implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotBlank(message = "O Campo Descrição é Obrigatório")
    private String descricao;

    @OneToMany(mappedBy = "estilo")
    private List<Cerveja> cervejaList;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Cerveja> getCervejaList() {
        return cervejaList;
    }

    public void setCervejaList(List<Cerveja> cervejaList) {
        this.cervejaList = cervejaList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estilo estilo = (Estilo) o;
        return Objects.equals(codigo, estilo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
