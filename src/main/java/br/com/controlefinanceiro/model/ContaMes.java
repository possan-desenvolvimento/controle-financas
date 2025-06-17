package br.com.controlefinanceiro.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name =  "tbcontas_mes")
public class ContaMes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tipoConta;
    private BigDecimal valorConta;
    private String situacaoConta;
    private String qtdParcelas;
    private LocalDate vencimentoConta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public BigDecimal getValorConta() {
        return valorConta;
    }

    public void setValorConta(BigDecimal valorConta) {
        this.valorConta = valorConta;
    }

    public String getSituacaoConta() {
        return situacaoConta;
    }

    public void setSituacaoConta(String situacaoConta) {
        this.situacaoConta = situacaoConta;
    }

    public String getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(String qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public LocalDate getVencimentoConta() {
        return vencimentoConta;
    }

    public void setVencimentoConta(LocalDate vencimentoConta) {
        this.vencimentoConta = vencimentoConta;
    }

    @Override
    public String toString() {
        return "\n------------------------------" +
                "\nID: " + id +
                "\nTipo de Conta: " + tipoConta +
                "\nValor da Conta: R$ " + valorConta +
                "\nSituação: " + situacaoConta +
                "\nParcelas: " + qtdParcelas +
                "\nVencimento: " + vencimentoConta +
                "\n------------------------------";
    }
}