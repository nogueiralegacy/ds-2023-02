package com.github.nogueiralegacy.ds.anotacao;

import java.util.ArrayList;
import java.util.List;

public class Diamante implements ItemObservado{
    List<Comprador> observadores = new ArrayList<>();
    private double preco;


    @Override
    public void adicionar(Comprador observador) {
        observadores.add(observador);
    }

    @Override
    public void remover(Comprador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificar() {
        if (observadores.size() > 0) {
            for (Comprador observador : observadores) {
                observador.atualizar(this);
            }
        }
    }

    public void setPreco(double preco) {
        this.preco = preco;
        notificar();
    }

    public double getPreco() {
        return this.preco;
    }
    
}
