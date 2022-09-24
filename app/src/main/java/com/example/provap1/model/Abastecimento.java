package com.example.provap1.model;

public class Abastecimento {

    private int id;
    private String quilometragem;
    private String quatidadeAbastecida;
    private String data_abastecimento;
    private String valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(String quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getQuatidadeAbastecida() {
        return quatidadeAbastecida;
    }

    public void setQuatidadeAbastecida(String quatidadeAbastecida) {
        this.quatidadeAbastecida = quatidadeAbastecida;
    }

    public String getData_abastecimento() {
        return data_abastecimento;
    }

    public void setData_abastecimento(String data_abastecimento) {
        this.data_abastecimento = data_abastecimento;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "data=" + data_abastecimento + " - quilometragem=" + quilometragem;
    }
}
