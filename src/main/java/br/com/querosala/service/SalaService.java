package br.com.querosala.service;

import br.com.querosala.dto.SalaCadastroDTO;
import br.com.querosala.dto.SalaDTO;
import br.com.querosala.model.Sala;
import br.com.querosala.repository.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalaService {

    //@Autowired
    //SalaRepository salaRepository;

    private final SalaRepository salaRepository;

    //injeção por construtor porque deixa as dependências explícitas,
    //permite trabalhar com atributos final, facilita testes unitários e é o
    // padrão recomendado atualmente pelo Spring.
    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }


        public List<SalaDTO> listarSalas(){
            return converterDadosParaDTO(salaRepository.findAll());
        }

        public SalaDTO cadastrarSala(SalaCadastroDTO dados){
            Sala sala = new Sala(
                    dados.nome(),
                    dados.capacidade(),
                    dados.andar()
            );

            Sala salaSalva = salaRepository.save(sala);

            return converterDadosParaDTO(salaSalva);
        }

    public SalaDTO buscarSalaPorId(Long id) {
        return salaRepository.findById(id)
                .map(this::converterDadosParaDTO)
                .orElseThrow();
    }

    public List<SalaDTO> buscarSalaPorAndar(Integer andar) {
        return converterDadosParaDTO(salaRepository.findByAndar(andar));
    }

    private List<SalaDTO> converterDadosParaDTO(List<Sala> salas){
        return salas.stream()
                .map(this::converterDadosParaDTO)
                .collect(Collectors.toList());
    }

    private SalaDTO converterDadosParaDTO(Sala sala){
        return new SalaDTO(
                sala.getId(),
                sala.getNome(),
                sala.getCapacidade(),
                sala.getAndar()
        );
    }
}
