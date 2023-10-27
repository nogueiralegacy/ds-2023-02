package com.github.nogueiralegacy.ds.anotacao;

import java.util.logging.Logger;

@Observador(itensObservados = {Diamante.class, Rubi.class})
public class Comprador {
    ItemObservado itemObservado;
    private static final Logger LOGGER = Logger.getLogger(Comprador.class.getName());

    public void atualizar(ItemObservado pedraPreciosa) {
        this.itemObservado = pedraPreciosa;
        System.out.println(("Comprador: " + pedraPreciosa.getClass().getName() + " mudou de preço para: " + pedraPreciosa.getPreco()));
    
    }
}



