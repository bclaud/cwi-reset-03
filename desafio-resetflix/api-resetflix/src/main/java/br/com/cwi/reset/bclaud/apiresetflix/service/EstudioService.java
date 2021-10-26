package br.com.cwi.reset.bclaud.apiresetflix.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.reset.bclaud.apiresetflix.exceptions.CampoVazioException;
import br.com.cwi.reset.bclaud.apiresetflix.exceptions.EstudioExceptions;
import br.com.cwi.reset.bclaud.apiresetflix.models.Estudio;
import br.com.cwi.reset.bclaud.apiresetflix.repositories.EstudioRepository;
import br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels.EstudioRequest;

@Service
public class EstudioService {

    @Autowired
    EstudioRepository estudioRepository;

    public void criarEstudio(EstudioRequest request) throws EstudioExceptions, CampoVazioException{

        Estudio estudio = estudioRequestToEstudio(request);

        if(isDuplicated(estudio)){
            throw new EstudioExceptions("Já existe um estúdio cadastrado para o nome "+estudio.getNome() +".");
        }

        if(!isValidCreationDate(estudio)){
            throw new EstudioExceptions("Não é possível cadastrar estúdios do futuro.");
        }

        estudioRepository.save(estudio);
    }

    public List<Estudio> consultarEstudios() throws EstudioExceptions{
        if(estudioRepository.findAll().isEmpty()){
            throw new EstudioExceptions("Nenhum estúdio cadastrado, favor cadastar estúdios.");
        }
        return estudioRepository.findAll();
    }

    public List<Estudio> consultarEstudios(String filtroNome) throws EstudioExceptions{
        List<Estudio> listaEstudio = consultarEstudios();
        List<Estudio> listaFiltrada = listaEstudio.stream()
        .filter(e -> e.getNome().toUpperCase().contains(filtroNome.toUpperCase()))
        .collect(Collectors.toList());

        if(listaFiltrada.isEmpty()){
            throw new EstudioExceptions("Estúdio não encontrado com o filtro " + filtroNome +", favor informar outro filtro.");
        }
        return listaFiltrada;
    }

    public Estudio consultarEstudio(Long id){
        return estudioRepository.findById(id).orElseThrow(() -> new EstudioExceptions("Nenhum estúdio encontrado com o parâmetro id="+id+", favor verifique os parâmetros informados."));
    }

    private boolean isDuplicated(Estudio estudio){
        return estudioRepository.findAll().stream()
        .anyMatch(e -> e.getNome().equalsIgnoreCase(estudio.getNome()));
    }

    private boolean isValidCreationDate(Estudio estudio){
        return estudio.getDataCriacao().isBefore(LocalDate.now());
    }

    private Estudio estudioRequestToEstudio(EstudioRequest request){
        Estudio estudio = new Estudio();
        estudio.setNome(request.getNome());
        estudio.setDescricao(request.getDescricao());
        estudio.setDataCriacao(request.getDataCriacao());
        estudio.setStatusAtividade(request.getStatusAtividade());
        return estudio;
    }
}
