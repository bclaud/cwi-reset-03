package br.com.cwi.reset.bclaud;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import br.com.cwi.reset.bclaud.enums.StatusCarreira;
import br.com.cwi.reset.bclaud.models.Ator;
import br.com.cwi.reset.bclaud.repositories.Repository;
import br.com.cwi.reset.bclaud.service.AtorService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Repository atorRepository = new Repository();
        AtorService atorService = new AtorService(atorRepository);

        Ator will = new Ator("Will Smith", LocalDate.of(1968, Month.SEPTEMBER, 25), StatusCarreira.EM_ATIVIDADE, 1986); 
        Ator will2 = new Ator("Will Smith", LocalDate.of(1968, Month.SEPTEMBER, 25), StatusCarreira.EM_ATIVIDADE, 1986); 


        atorService.criarAtor(will);
        atorService.criarAtor(will2);


        List<Ator> listaConsultada = atorService.listarAtoresEmAtividade();
        

        listaConsultada.stream().forEach(ator -> System.out.println("id: " + ator.getId() + " Nome: " + ator.getNome()));
    }
}
