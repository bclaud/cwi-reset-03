package br.com.cwi.reset.bclaud.apiresetflix.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.reset.bclaud.apiresetflix.exceptions.AtorExceptions;
import br.com.cwi.reset.bclaud.apiresetflix.exceptions.CampoVazioException;
import br.com.cwi.reset.bclaud.apiresetflix.models.Ator;
import br.com.cwi.reset.bclaud.apiresetflix.repositories.AtorRepository;
import br.com.cwi.reset.bclaud.apiresetflix.service.requestmodels.AtorRequest;
import br.com.cwi.reset.bclaud.apiresetflix.service.responsemodels.AtorEmAtividade;

@Service
public class AtorService {

    @Autowired
    private AtorRepository atorRepository;

    public void criarAtor(AtorRequest request) throws AtorExceptions {

        Ator ator = atorRequestToAtor(request);
        if (isDuplicated(ator)) {
            throw new AtorExceptions("Já existe um ator cadastrado para o nome " + ator.getNome());
        }
        if (!isValidBirthdate(ator)) {
            throw new AtorExceptions("Não é possível cadastrar atores não nascidos.");
        }
        if (!isValidActivityStartdate(ator)) {
            throw new AtorExceptions("Ano de início de atividade inválido para o ator cadastrado.");
        }
        if (!isValidName(ator)) {
            throw new AtorExceptions("Deve ser informado no mínimo nome e sobrenome para o ator.");
        }

        atorRepository.save(ator);
    }

    public List<AtorEmAtividade> listarAtoresEmAtividade() throws AtorExceptions {
        if (atorRepository.findAll().isEmpty()) {
            throw new AtorExceptions("Nenhum ator cadastrado, favor cadastrar atores.");
        }
        return atorRepository.findAll().stream()
                .filter(ator -> ator.getStatusCarreira().toString().equals("EM_ATIVIDADE"))
                .map(ator -> new AtorEmAtividade(ator)).collect(Collectors.toList());
    }

    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws AtorExceptions {
        List<AtorEmAtividade> listaFiltrada = listarAtoresEmAtividade().stream()
                .filter(ator -> ator.getNome().toUpperCase().contains(filtroNome.toUpperCase()))
                .collect(Collectors.toList());

        if (listaFiltrada.isEmpty()) {
            throw new AtorExceptions(
                    "Ator não encontrato com o filtro " + filtroNome + ", favor informar outro filtro.");
        }

        return listaFiltrada;
    }

    public Ator consultarAtor(Long id) throws AtorExceptions, CampoVazioException {
        if (id == null) {
            throw new CampoVazioException("id");
        }

        return atorRepository.findById(id).orElseThrow(() -> new AtorExceptions(
                "Nenhum ator encontrado com o parâmetro id=" + id + ", favor verifique os parâmetros informados."));
    }

    public List<Ator> consultarAtores() throws AtorExceptions {
        List<Ator> listaAtores = atorRepository.findAll();
        if (listaAtores.isEmpty()) {
            throw new AtorExceptions("Nenhum ator cadastrado, favor cadastar atores.");
        }
        return listaAtores;
    }

    private boolean isDuplicated(Ator ator) {
        return atorRepository.findAll().stream().anyMatch(a -> a.getNome().equalsIgnoreCase(ator.getNome()));
    }

    private boolean isValidBirthdate(Ator ator) {
        return ator.getDataNascimento().isBefore(LocalDate.now());
    }

    private boolean isValidActivityStartdate(Ator ator) {
        return ator.getAnoInicioAtividade() > ator.getDataNascimento().getYear();
    }

    private boolean isValidName(Ator ator) {
        return ator.getNome().contains(" ");
    }

    private Ator atorRequestToAtor(AtorRequest request) {
        return new Ator(request.getNome(), request.getDataNascimento(), request.getStatusCarreira(),
                request.getAnoInicioAtividade());
    }
}
