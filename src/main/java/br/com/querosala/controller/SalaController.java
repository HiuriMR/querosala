package br.com.querosala.controller;

import br.com.querosala.dto.SalaAtualizacaoDTO;
import br.com.querosala.dto.SalaCadastroDTO;
import br.com.querosala.dto.SalaDTO;
import br.com.querosala.service.SalaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    private final SalaService salaService;

    //injeção por construtor porque deixa as dependências explícitas,
    //permite trabalhar com atributos finais, facilita testes unitários e é o
    // padrão recomendado atualmente pelo Spring.
    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }
    //listar todas as salas
    @GetMapping
    public ResponseEntity<List<SalaDTO>> listarSalas(){
        List<SalaDTO> lista =  salaService.listarSalas();
        return ResponseEntity.ok(lista);

    }
    //cadastrar uma sala
    @PostMapping
    @Transactional
    public ResponseEntity<SalaDTO> cadastrarSala(@RequestBody @Valid SalaCadastroDTO dados){
        SalaDTO sala = salaService.cadastrarSala(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(sala);
    }

    //Buscar sala por id
    @GetMapping("/{id}")
    public ResponseEntity<SalaDTO> buscarSalaPorId(@PathVariable Long id){ //@PathVariable Obtém um valor que faz parte da URL.
        SalaDTO sala = salaService.buscarSalaPorId(id);
        return ResponseEntity.ok(sala);
    }

    //Buscar salas por andar
    @GetMapping(params = "andar")//quando for usar o @RequestParam
    public ResponseEntity<List<SalaDTO>> buscarSalaPorAndar(@RequestParam Integer andar){ //@RequestParam Obtém um valor que vem após o ?.
        List<SalaDTO> salas = salaService.buscarSalaPorAndar(andar);
        return ResponseEntity.ok(salas);
    }

    //Atualizar salas por id
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<SalaDTO> atualizarSala(
            @PathVariable Long id,
            @Valid @RequestBody SalaAtualizacaoDTO dados){

        SalaDTO salaAtualizada = salaService.atualizarSala(id,dados);
        return ResponseEntity.ok(salaAtualizada);
    }

    //Apagar salas por id
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirSala(@PathVariable Long id){
        salaService.excluirSala(id);
        return ResponseEntity.noContent().build();
    }

}
