package com.github.nogueiralegacy.ds.anotacao;

import java.util.ArrayList;
import java.util.List;

public class Venda implements ItemObservado{
    List<Observador> observadores = new ArrayList<>();
    private boolean efetuada = false;

    @Override
    public void adicionar(Observador observador) {
        Class<?> classe = observador.getClass();

        if (classe.isAnnotationPresent(ObservadorAnotacao.class))  {
             String identificadorObservador = classe.getAnnotation(ObservadorAnotacao.class).itemObservado();
            if (identificadorObservador.equals(this.getIdentificador())) {
                observadores.add(observador);
            }
        }
    }
    @Override
    public void remover(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public String getIdentificador() {
        return "identificadorUnicoDeVenda";
    }

    @Override
    public void notificar() {
        for (Observador observador : observadores) {
            observador.update();
        }
    }

    public void setStatus(boolean efetuada) {
        this.efetuada = efetuada;
        if (efetuada) {
            notificar();
        }
    }
}
