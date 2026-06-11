package br.com.querosala.controller;

import br.com.querosala.dto.SalaCadastroDTO;
import br.com.querosala.dto.SalaDTO;
import br.com.querosala.repository.ReservaRepository;
import br.com.querosala.service.SalaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    private final SalaService salaService;

    //injeção por construtor porque deixa as dependências explícitas,
    //permite trabalhar com atributos final, facilita testes unitários e é o
    // padrão recomendado atualmente pelo Spring.
    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    public List<SalaDTO> listarSalas(){
        return salaService.listarSalas();
    }

    @PostMapping
    public SalaDTO cadastrarSala(
            @Valid @RequestBody SalaCadastroDTO dados) {

        return salaService.cadastrarSala(dados);
    }

    @GetMapping("/{id}")
    public SalaDTO buscarSalaPorId(@PathVariable Long id){ //@PathVariable Obtém um valor que faz parte da URL.
        return salaService.buscarSalaPorId(id);
    }

    @GetMapping(params = "andar")//quando for usar o @RequestParam
    public List<SalaDTO> buscarSalaPorAndar(@RequestParam Integer andar){ //@RequestParam Obtém um valor que vem após o ?.
        return salaService.buscarSalaPorAndar(andar);
    }


}
