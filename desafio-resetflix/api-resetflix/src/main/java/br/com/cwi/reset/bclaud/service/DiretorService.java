package br.com.cwi.reset.bclaud.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.cwi.reset.bclaud.exceptions.DiretorExceptions;
import br.com.cwi.reset.bclaud.models.Diretor;
import br.com.cwi.reset.bclaud.repositories.Repository;

public class DiretorService extends UserServiceAbstract {
    Repository diretorRepository;

    public DiretorService(Repository diretorRepository){
        super(diretorRepository);
        this.diretorRepository = diretorRepository;
    }

    public void cadastrarDiretor(Diretor diretor) throws DiretorExceptions{
        //TODO falta exception do campo
        if(super.isDuplicated(diretor)){
            throw new DiretorExceptions("Já existe um diretor cadastrado para o nome " + diretor.getNome() +".");
        }
        if(!super.isValidBirthdate(diretor)){
            throw new DiretorExceptions("Não é possível cadastrar diretores não nascidos.");
        }
        if(!super.isValidActivityStartdate(diretor)){
            throw new DiretorExceptions("Ano de início de atividade inválido para o diretor cadastrado.");
        }
        if(!super.isValidName(diretor)){
            throw new DiretorExceptions("Deve ser informado no mínimo nome e sobrenome para o diretor.");
        }

        diretor.setId(idGenerator());
        diretorRepository.salvarDiretor(diretor);
    }

    public List<Diretor> listarDiretores(String filtroNome) throws DiretorExceptions{
        List<Diretor> listaDiretoresFiltrado = diretorRepository.listarDiretores().stream()
        .filter(diretor -> diretor.getNome().toUpperCase().contains(filtroNome.toUpperCase()))
        .collect(Collectors.toList());

        if(listaDiretoresFiltrado.isEmpty()){
            throw new DiretorExceptions("Diretor não encontrato com o filtro "+ filtroNome +", favor informar outro filtro.");
        }

        return listaDiretoresFiltrado;
    }

    public List<Diretor> listarDiretores() throws DiretorExceptions{
        List<Diretor> listaDiretor = diretorRepository.listarDiretores().stream()
        .collect(Collectors.toList());

        if(listaDiretor.isEmpty()){
            throw new DiretorExceptions("Nenhum diretor cadastrado, favor cadastar diretores.");
        }

        return listaDiretor;
    }

    public Diretor consultarDiretor(Long id) throws DiretorExceptions{
        //TODO falta exception campo obrigatorio
        return diretorRepository.consultarDiretor(id)
        .orElseThrow(() -> new DiretorExceptions("Nenhum diretor encontrado com o parâmetro id="+id+", favor verifique os parâmetros informados."));
    }

    public Long idGenerator(){
        return (long) diretorRepository.listarDiretores().size();
    }
}
