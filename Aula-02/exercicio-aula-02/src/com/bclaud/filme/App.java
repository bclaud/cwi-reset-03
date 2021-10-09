package com.bclaud.filme;

import com.bclaud.filme.enuns.Genero;
import com.bclaud.filme.model.Diretor;
import com.bclaud.filme.model.Filme;

public class App {
    public static void main(String[] args) throws Exception {
        Diretor miyazaki = new Diretor("Hayao Miyazaki", 80, 12, Genero.MASCULINO);
        Diretor spielberg = new Diretor("Steven Spielberg", 75, 32, Genero.MASCULINO);

        Filme casteloAnimado = new Filme("Castelo animado", "Uma garota insegura recebe uma terrível maldição de uma bruxa e sua unica chance de quebra-la é se tornando corajosa", 118, 2001, 5.00, miyazaki);
        Filme readyPlayerOne = new Filme("Ready Player One", "Players do Jogo em realidade Virtual mais popular do mundo são desafiados a cumprir desafios para receber o controle do game", 140, 2018, 4.5, spielberg);

        casteloAnimado.reproduzir();
        System.out.println("----------");
        readyPlayerOne.reproduzir();
        System.out.println("----------");

    }
}
