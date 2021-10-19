package br.com.cwi.reset.bclaud.apiresetflix.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.cwi.reset.bclaud.apiresetflix.exceptions.CampoVazioException;
import br.com.cwi.reset.bclaud.apiresetflix.exceptions.EstudioExceptions;
import br.com.cwi.reset.bclaud.apiresetflix.models.Estudio;
import br.com.cwi.reset.bclaud.apiresetflix.repositories.Repository;
import br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels.EstudioRequest;

public class EstudioService {

    public static EstudioService estudioService = new EstudioService(Repository.getInstance());

    public static EstudioService getInstance(){
        return estudioService;
    }

    Repository estudioRepository;

    public EstudioService(Repository diretorRepository){
        this.estudioRepository = diretorRepository;
    }

    public void criarEstudio(EstudioRequest request) throws EstudioExceptions, CampoVazioException{
        String checkCampo = checkNullFields(request);
        if(checkCampo != null){
            throw new CampoVazioException(checkCampo);
        }

        Estudio estudio = estudioRequestToEstudio(request);

        if(isDuplicated(estudio)){
            throw new EstudioExceptions("Já existe um estúdio cadastrado para o nome "+estudio.getNome() +".");
        }

        if(!isValidCreationDate(estudio)){
            throw new EstudioExceptions("Não é possível cadastrar estúdios do futuro.");
        }

        estudio.setId(idGenerator());
        estudioRepository.persisteEstudio(estudio);
    }

    public List<Estudio> consultarEstudios() throws EstudioExceptions{
        if(estudioRepository.recuperaEstudios().isEmpty()){
            throw new EstudioExceptions("Nenhum estúdio cadastrado, favor cadastar estúdios.");
        }
        return estudioRepository.recuperaEstudios();
    }

    public List<Estudio> consultarEstudios(String filtroNome) throws EstudioExceptions{
        List<Estudio> listaEstudio = consultarEstudios();
        List<Estudio> listaFiltrada = listaEstudio.stream()
        .filter(e -> e.getNome().toUpperCase().contains(filtroNome.toUpperCase()))
        .collect(Collectors.toList());

        if(listaFiltrada.isEmpty()){
            throw new EstudioExceptions("Estúdio não encontrato com o filtro " + filtroNome +", favor informar outro filtro.");
        }
        return listaFiltrada;
    }

    public Estudio consultarEstudio(Long id){
        return estudioRepository.consultarEstudio(id).orElseThrow(() -> new EstudioExceptions("Nenhum estúdio encontrado com o parâmetro id="+id+", favor verifique os parâmetros informados."));
    }

    public boolean isDuplicated(Estudio estudio){
        return estudioRepository.recuperaEstudios().stream()
        .anyMatch(e -> e.getNome().equalsIgnoreCase(estudio.getNome()));
    }

    public boolean isValidCreationDate(Estudio estudio){
        return estudio.getDataCriacao().isBefore(LocalDate.now());
    }

    public String checkNullFields(EstudioRequest request){
        if(request.getNome() == null){
            return "nome";
        }

        if(request.getDescricao() == null){
            return "descricao";
        }

        if(request.getDataCriacao() == null){
            return "data criacao";
        }

        if(request.getStatusAtividade() == null){
            return "status atividade";
        }

        return null;
    }

    public Estudio estudioRequestToEstudio(EstudioRequest request){
        Estudio estudio = new Estudio();
        estudio.setNome(request.getNome());
        estudio.setDescricao(request.getDescricao());
        estudio.setDataCriacao(request.getDataCriacao());
        estudio.setStatusAtividade(request.getStatusAtividade());
        return estudio;
    }

    public Long idGenerator(){
        return (long) estudioRepository.recuperaEstudios().size() + 1;
    }
}
