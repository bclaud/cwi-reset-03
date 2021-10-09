package com.bclaud.filme;

import com.bclaud.filme.model.Diretor;
import com.bclaud.filme.model.Filme;

public class App {
    public static void main(String[] args) throws Exception {
        Filme filme1 = new Filme("Castelo animado", "Uma garota insegura recebe uma terrível maldição de uma bruxa e sua unica chance de quebra-la é se tornando corajosa", 118, 2001, new Diretor("Hayao Miyazaki", 80, 12));
        Filme filme2 = new Filme("Ready Player One", "Players do Jogo em realidade Virtual mais popular do mundo são desafiados a cumprir desafios para receber o controle do game", 140, 2018, new Diretor("Steven Spielberg", 75, 32));

        filme1.reproduzir();
        System.out.println("----------");
        filme2.reproduzir();
    }
}
