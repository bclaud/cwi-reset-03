package br.com.cwi.reset.bclaud.apiresetflix.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.cwi.reset.bclaud.apiresetflix.exceptions.AtorExceptions;
import br.com.cwi.reset.bclaud.apiresetflix.exceptions.CampoVazioException;
import br.com.cwi.reset.bclaud.apiresetflix.models.Ator;
import br.com.cwi.reset.bclaud.apiresetflix.repositories.Repository;
import br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels.AtorRequest;
import br.com.cwi.reset.bclaud.apiresetflix.service.responsemodels.AtorEmAtividade;

public class AtorService {
    
    private Repository atorRepository;

    public AtorService(Repository atorRepository){
        this.atorRepository = atorRepository;
    }

    public void criarAtor(AtorRequest request) throws AtorExceptions, CampoVazioException{
        String checkCampo = checkNullFields(request);
        if(checkCampo != null){
            throw new CampoVazioException(checkCampo);
        }

        Ator ator = atorRequestToAtor(request);
        if(isDuplicated(ator)){
            throw new AtorExceptions("Já existe um ator cadastrado para o nome " + ator.getNome());
        }        
        if(!isValidBirthdate(ator)){
            throw new AtorExceptions("Não é possível cadastrar atores não nascidos.");
        }
        if(!isValidActivityStartdate(ator)){
            throw new AtorExceptions("Ano de início de atividade inválido para o ator cadastrado.");
        }
        if(!isValidName(ator)){
            throw new AtorExceptions("Deve ser informado no mínimo nome e sobrenome para o ator.");
        }

        ator.setId(idGenerator());
        atorRepository.persisteAtor(ator);
    }

    public List<AtorEmAtividade> listarAtoresEmAtividade(){
        if(atorRepository.recuperaAtores().isEmpty()){
            throw new AtorExceptions("Nenhum ator cadastrado, favor cadastar atores.");
        }
        return atorRepository.recuperaAtores().stream()
        .filter(ator -> ator.getStatusCarreira().toString().equals("EM_ATIVIDADE"))
        .map(ator -> new AtorEmAtividade(ator))
        .collect(Collectors.toList());
    }

    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome){
        List<AtorEmAtividade> listaFiltrada =  listarAtoresEmAtividade().stream()
        .filter(ator -> ator.getNome().toUpperCase().contains(filtroNome.toUpperCase()))
        .collect(Collectors.toList());

        if(listaFiltrada.isEmpty()){
            throw new AtorExceptions("Ator não encontrato com o filtro "+ filtroNome +", favor informar outro filtro.");
        }

        return listaFiltrada;
    }

    public Ator consultarAtor(Long id) throws AtorExceptions, CampoVazioException{
        if(id == null){
            throw new CampoVazioException("id");
        }

        return atorRepository.consultarAtor(id)
        .orElseThrow(() -> new AtorExceptions("Nenhum ator encontrado com o parâmetro id="+id+", favor verifique os parâmetros informados."));
    }

    public List<Ator> consultarAtores(){
        List<Ator> listaAtores = atorRepository.recuperaAtores();
        if(listaAtores.isEmpty()){
            throw new AtorExceptions("Nenhum ator cadastrado, favor cadastar atores.");
        }
        return listaAtores;
    }

    public boolean isDuplicated(Ator ator){
        return atorRepository.recuperaAtores().stream()
        .anyMatch(a -> a.getNome().equalsIgnoreCase(ator.getNome()));
    }

    public boolean isValidBirthdate(Ator ator){
        return ator.getDataNascimento().isBefore(LocalDate.now());
    }

    public boolean isValidActivityStartdate(Ator ator){
        return ator.getAnoInicioAtividade() > ator.getDataNascimento().getYear();
    }

    public boolean isValidName(Ator ator){
        return ator.getNome().contains(" ");
    }

    public Ator atorRequestToAtor(AtorRequest request){
        return new Ator(request.getNome(), request.getDataNascimento(), request.getStatusCarreira(), request.getAnoInicioAtividade());
    }

    public String checkNullFields(AtorRequest request){
        if(request.getNome() == null){
            return "nome";
        }

        if(request.getDataNascimento() == null){
            return "data de nascimento";
        }

        if(request.getAnoInicioAtividade() == null){
            return "ano inicio nascimento";
        }

        if(request.getStatusCarreira() == null){
            return "status carreira";
        }
        
        return null;
    }

    public Long idGenerator(){
        return (long) atorRepository.recuperaAtores().size() + 1;
    }
}
