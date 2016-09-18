package com.brewer.model;

import com.brewer.validation.Sku;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "cerveja")
public class Cerveja {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Sku
    @NotBlank(message = "SKU é obrigatório")
    private String sku;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Descrição é obrigatório")
    private String descricao;

    @NotNull(message = "Valor é obrigatório")
    @DecimalMin(value = "0.50", message = "O valor da cerveja deve ser maior que R$0,50")
    @DecimalMax(value = "9999999.99", message = "O valor da cerveja deve ser menor que R$9.999.999,99")
    private BigDecimal valor;

    @NotNull(message = "O Teor alcóolico é obrigatório")
    @DecimalMax(value = "100.0", message = "O valor do teor alcóolico deve ser menor que 100")
    @Column(name = "teor_alcoolico")
    private BigDecimal teorAlcolico;

    @DecimalMax(value = "100.0", message = "A Comissão deve ser igual ou menor que 100")
    private BigDecimal comissao;

    @Max(value = 9999, message = "A Quantidade em estoque deve ser menor que 9.999")
    @Column(name = "quantidade_estoque")
    private Integer quantidadeEstoque;

    @NotNull(message = "A Origem é obrigatória")
    @Enumerated(EnumType.STRING)
    private Origem origem;

    @NotNull(message = "O Sabor é obrigatória")
    @Enumerated(EnumType.STRING)
    private Sabor sabor;

    @NotNull(message = "O Estilo é obrigatório")
    @ManyToOne
    @JoinColumn(name = "codigo_estilo")
    private Estilo estilo;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getTeorAlcolico() {
        return teorAlcolico;
    }

    public void setTeorAlcolico(BigDecimal teorAlcolico) {
        this.teorAlcolico = teorAlcolico;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cerveja cerveja = (Cerveja) o;
        return Objects.equals(codigo, cerveja.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
