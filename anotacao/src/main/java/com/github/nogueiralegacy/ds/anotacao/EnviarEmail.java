package com.github.nogueiralegacy.ds.anotacao;

@ObservadorAnotacao(itemObservado = "identificadorUnicoDeVenda")
public class EnviarEmail implements Observador{
    @Override
    public void update() {
        System.out.println("Email enviado com sucesso!");

    }
}
