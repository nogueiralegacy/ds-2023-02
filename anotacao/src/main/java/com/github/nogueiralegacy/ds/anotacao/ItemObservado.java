package com.github.nogueiralegacy.ds.anotacao;

public interface ItemObservado {
    // metodo adicionar
    void adicionar(Comprador observador);
    // metodo remover
    void remover(Comprador observador);
    // metodo notificar
    void notificar();

    double getPreco();

    void setPreco(double preco);
}
