package br.com.querosala.controller;

import br.com.querosala.dto.ReservaAtualizacaoDTO;
import br.com.querosala.dto.ReservaCadastroDTO;
import br.com.querosala.dto.ReservaDTO;
import br.com.querosala.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService){
        this.reservaService = reservaService;
    }

    @GetMapping
    public List<ReservaDTO> listarReservas(){
        return reservaService.listarReservas();
    }

    @GetMapping("/{id}")
    public ReservaDTO buscarReservaPorId(@PathVariable Long id){ //@PathVariable Obtém um valor que faz parte da URL.
        return reservaService.buscarReservaPorId(id);
    }

    @PostMapping
    public ReservaDTO cadastrarReserva(
            @Valid @RequestBody ReservaCadastroDTO dados) {

        return reservaService.cadastrarReserva(dados);
    }

    @PutMapping("/{id}")
    public ReservaDTO atualizarReserva(
            @PathVariable Long id,
            @Valid @RequestBody ReservaAtualizacaoDTO dados){

        return reservaService
                .atualizarReserva(
                        id,
                        dados);
    }

    @DeleteMapping("/{id}")
    public void excluirReserva(@PathVariable Long id){
        reservaService.excluirReserva(id);
    }
}
