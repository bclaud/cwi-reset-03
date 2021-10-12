package br.com.cwi.reset.bclaud.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.cwi.reset.bclaud.exceptions.AtorExceptions;
import br.com.cwi.reset.bclaud.models.Ator;
import br.com.cwi.reset.bclaud.repositories.Repository;

public class AtorService extends UserServiceAbstract{
    
    private Repository atorRepository;

    public AtorService(Repository atorRepository){
        super(atorRepository);
        this.atorRepository = atorRepository;
    }

    public void criarAtor(Ator ator) throws AtorExceptions {
        if(super.isDuplicated(ator)){
            throw new AtorExceptions("Já existe um ator cadastrado para o nome " + ator.getNome());
        }        
        if(!super.isValidBirthdate(ator)){
            throw new AtorExceptions("Não é possível cadastrar atores não nascidos.");
        }
        if(!super.isValidActivityStartdate(ator)){
            throw new AtorExceptions("Ano de início de atividade inválido para o ator cadastrado.");
        }
        if(!super.isValidName(ator)){
            throw new AtorExceptions("Deve ser informado no mínimo nome e sobrenome para o ator.");
        }

        ator.setId(idGenerator());
        atorRepository.salvarAtor(ator);
        // TODO falta a exception de campos faltando
    }

    public List<Ator> listarAtoresEmAtividade() throws AtorExceptions {
        if(atorRepository.listarAtores().isEmpty()){
            throw new AtorExceptions("Nenhum ator cadastrado, favor cadastar atores.");
        }
        return atorRepository.listarAtores().stream()
        .filter(ator -> ator.getStatusCarreira().toString().equals("EM_ATIVIDADE"))
        .collect(Collectors.toList());
    }

    public List<Ator> listarAtoresEmAtividade(String filtroNome) throws AtorExceptions {
        List<Ator> listaFiltrada =  listarAtoresEmAtividade().stream()
        .filter(ator -> ator.getNome().toUpperCase().contains(filtroNome.toUpperCase()))
        .collect(Collectors.toList());

        if(listaFiltrada.isEmpty()){
            throw new AtorExceptions("Ator não encontrato com o filtro "+ filtroNome +", favor informar outro filtro.");
        }

        return listaFiltrada;
    }

    public Ator consultarAtor(Long id) throws AtorExceptions {
        //TODO falta exception de campo obrigatorio
        return atorRepository.consultarAtor(id)
        .orElseThrow(() -> new AtorExceptions("Nenhum ator encontrado com o parâmetro id="+id+", favor verifique os parâmetros informados."));
    }

    public List<Ator> consultarAtores() throws AtorExceptions {
        List<Ator> listaAtores = atorRepository.listarAtores();
        if(listaAtores.isEmpty()){
            throw new AtorExceptions("Nenhum ator cadastrado, favor cadastar atores.");
        }
        return listaAtores;
    }
    
    public Long idGenerator(){
        return (long) atorRepository.listarAtores().size();
    }
}
