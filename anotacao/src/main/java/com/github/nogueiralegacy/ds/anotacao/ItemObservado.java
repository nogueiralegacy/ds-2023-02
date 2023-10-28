package com.github.nogueiralegacy.ds.anotacao;

public interface ItemObservado {
    // metodo adicionar
    void adicionar(Observador observador);
    // metodo remover
    void remover(Observador observador);
    // metodo notificar
    void notificar();
    // metodo para retornar o identificador
    String getIdentificador();
}
