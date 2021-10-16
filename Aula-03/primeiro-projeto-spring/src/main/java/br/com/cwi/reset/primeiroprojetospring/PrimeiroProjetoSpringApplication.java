package br.com.cwi.reset.primeiroprojetospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrimeiroProjetoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeiroProjetoSpringApplication.class, args);
		
		// FilmeController.listaFilmes.add(new Filme("Meu amigo totoro", "Tem um gatonibus maneirasso", 120, 2001, 5.00, new Diretor("Miyamoto", "1975-01-01", 21, Genero.MASCULINO)));
	}

}
