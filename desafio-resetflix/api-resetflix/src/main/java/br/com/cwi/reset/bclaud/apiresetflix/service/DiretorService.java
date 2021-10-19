package br.com.cwi.reset.bclaud.apiresetflix.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.cwi.reset.bclaud.apiresetflix.exceptions.CampoVazioException;
import br.com.cwi.reset.bclaud.apiresetflix.exceptions.DiretorExceptions;
import br.com.cwi.reset.bclaud.apiresetflix.models.Diretor;
import br.com.cwi.reset.bclaud.apiresetflix.repositories.Repository;
import br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels.DiretorRequest;

public class DiretorService {
    Repository diretorRepository;

    public DiretorService(Repository diretorRepository){
        this.diretorRepository = diretorRepository;
    }

    public void cadastrarDiretor(DiretorRequest request) throws DiretorExceptions, CampoVazioException{
        String checkCampos = checkNullFields(request);
        
        if(checkCampos != null){
            throw new CampoVazioException(checkCampos);
        }

        Diretor diretor = diretorRequestToDiretor(request);
        if(isDuplicated(diretor)){
            throw new DiretorExceptions("Já existe um diretor cadastrado para o nome " + diretor.getNome() +".");
        }
        if(!isValidBirthdate(diretor)){
            throw new DiretorExceptions("Não é possível cadastrar diretores não nascidos.");
        }
        if(!isValidActivityStartdate(diretor)){
            throw new DiretorExceptions("Ano de início de atividade inválido para o diretor cadastrado.");
        }
        if(!isValidName(diretor)){
            throw new DiretorExceptions("Deve ser informado no mínimo nome e sobrenome para o diretor.");
        }

        diretor.setId(idGenerator());
        diretorRepository.persisteDiretor(diretor);
    }

    public List<Diretor> listarDiretores(String filtroNome) throws DiretorExceptions{
        List<Diretor> listaDiretoresFiltrado = diretorRepository.recuperaDiretores().stream()
        .filter(diretor -> diretor.getNome().toUpperCase().contains(filtroNome.toUpperCase()))
        .collect(Collectors.toList());

        if(listaDiretoresFiltrado.isEmpty()){
            throw new DiretorExceptions("Diretor não encontrato com o filtro "+ filtroNome +", favor informar outro filtro.");
        }

        return listaDiretoresFiltrado;
    }

    public List<Diretor> listarDiretores() throws DiretorExceptions{
        List<Diretor> listaDiretor = diretorRepository.recuperaDiretores().stream()
        .collect(Collectors.toList());

        if(listaDiretor.isEmpty()){
            throw new DiretorExceptions("Nenhum diretor cadastrado, favor cadastar diretores.");
        }

        return listaDiretor;
    }

    public Diretor consultarDiretor(Long id) throws DiretorExceptions, CampoVazioException{
        if(id == null){
            throw new CampoVazioException("id");
        }

        return diretorRepository.consultarDiretor(id)
        .orElseThrow(() -> new DiretorExceptions("Nenhum diretor encontrado com o parâmetro id="+id+", favor verifique os parâmetros informados."));
    }

    public boolean isDuplicated(Diretor diretor){
        return diretorRepository.recuperaDiretores().stream()
        .anyMatch(d -> d.getNome().equalsIgnoreCase(diretor.getNome()));
    }

    public boolean isValidBirthdate(Diretor diretor){
        return diretor.getDataNascimento().isBefore(LocalDate.now());
    }

    public boolean isValidActivityStartdate(Diretor diretor){
        return diretor.getAnoInicioAtividade() > diretor.getDataNascimento().getYear();
    }

    public boolean isValidName(Diretor diretor){
        return diretor.getNome().contains(" ");
    }

    public Diretor diretorRequestToDiretor(DiretorRequest request){
        return new Diretor(request.getNome(), request.getDataNascimento(), request.getAnoInicioAtividade());
    }

    public String checkNullFields(DiretorRequest request){
        if(request.getNome() == null){
            return "nome";
        }

        if(request.getDataNascimento() == null){
            return "data de nascimento";
        }

        if(request.getAnoInicioAtividade() == null){
            return "ano inicio atividade";
        }
        
        return null;
    }

    public Long idGenerator(){
        return (long) diretorRepository.recuperaDiretores().size() + 1;
    }
}
