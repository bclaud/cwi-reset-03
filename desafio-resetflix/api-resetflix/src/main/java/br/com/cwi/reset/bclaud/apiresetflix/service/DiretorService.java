package br.com.cwi.reset.bclaud.apiresetflix.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.reset.bclaud.apiresetflix.exceptions.CampoVazioException;
import br.com.cwi.reset.bclaud.apiresetflix.exceptions.DiretorExceptions;
import br.com.cwi.reset.bclaud.apiresetflix.models.Diretor;
import br.com.cwi.reset.bclaud.apiresetflix.repositories.DiretorRepository;
import br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels.DiretorRequest;

@Service
public class DiretorService {

    @Autowired
    DiretorRepository diretorRepository;

    @Autowired
    FilmeService filmeService;

    public void cadastrarDiretor(DiretorRequest request) throws DiretorExceptions, CampoVazioException {
        Diretor diretor = diretorRequestToDiretor(request);
        if (isDuplicated(diretor)) {
            throw new DiretorExceptions("Já existe um diretor cadastrado para o nome " + diretor.getNome() + ".");
        }
        if (!isValidBirthdate(diretor)) {
            throw new DiretorExceptions("Não é possível cadastrar diretores não nascidos.");
        }
        if (!isValidActivityStartdate(diretor)) {
            throw new DiretorExceptions("Ano de início de atividade inválido para o diretor cadastrado.");
        }
        if (!isValidName(diretor)) {
            throw new DiretorExceptions("Deve ser informado no mínimo nome e sobrenome para o diretor.");
        }

        diretorRepository.save(diretor);
    }

    public List<Diretor> listarDiretores(String filtroNome) throws DiretorExceptions {
        List<Diretor> listaDiretoresFiltrado = diretorRepository.findAll().stream()
                .filter(diretor -> diretor.getNome().toUpperCase().contains(filtroNome.toUpperCase()))
                .collect(Collectors.toList());

        if (listaDiretoresFiltrado.isEmpty()) {
            throw new DiretorExceptions(
                    "Diretor não encontrato com o filtro " + filtroNome + ", favor informar outro filtro.");
        }

        return listaDiretoresFiltrado;
    }

    public List<Diretor> listarDiretores() throws DiretorExceptions {
        List<Diretor> listaDiretor = diretorRepository.findAll().stream().collect(Collectors.toList());

        if (listaDiretor.isEmpty()) {
            throw new DiretorExceptions("Nenhum diretor cadastrado, favor cadastar diretores.");
        }

        return listaDiretor;
    }

    public Diretor consultarDiretor(Long id) throws DiretorExceptions, CampoVazioException {
        if (id == null) {
            throw new CampoVazioException("id");
        }

        return diretorRepository.findById(id).orElseThrow(() -> new DiretorExceptions(
                "Nenhum diretor encontrado com o parâmetro id=" + id + ", favor verifique os parâmetros informados."));
    }

    public void atualizarDiretor(Long id, DiretorRequest request) {
        Diretor diretorAtualizado = diretorRequestToDiretor(request);
        diretorAtualizado.setId(consultarDiretor(id).getId());
        if (isDuplicated(diretorAtualizado)) {
            throw new DiretorExceptions("Já existe um diretor cadastrado para o nome " + diretorAtualizado.getNome());
        }

        diretorRepository.save(diretorAtualizado);
    }

    public void removerDiretor(Long id) {
        Diretor diretorParaRemover = consultarDiretor(id);

        if (hasMovies(diretorParaRemover)) {
            throw new DiretorExceptions(
                    "Este diretor está vinculado a um ou mais filmes, para remover o diretor é necessário remover os seus filmes de participação.");
        }
        diretorRepository.delete(diretorParaRemover);
    }

    private boolean hasMovies(Diretor diretor) {
        return filmeService.consultarFilmes().stream()
                .anyMatch(d -> d.getDiretor().getNome().equalsIgnoreCase(diretor.getNome()));
    }

    private boolean isDuplicated(Diretor diretor) {
        return diretorRepository.findAll().stream().anyMatch(d -> d.getNome().equalsIgnoreCase(diretor.getNome()));
    }

    private boolean isValidBirthdate(Diretor diretor) {
        return diretor.getDataNascimento().isBefore(LocalDate.now());
    }

    private boolean isValidActivityStartdate(Diretor diretor) {
        return diretor.getAnoInicioAtividade() > diretor.getDataNascimento().getYear();
    }

    private boolean isValidName(Diretor diretor) {
        return diretor.getNome().contains(" ");
    }

    private Diretor diretorRequestToDiretor(DiretorRequest request) {
        return new Diretor(request.getNome(), request.getDataNascimento(), request.getAnoInicioAtividade());
    }

}
