package br.com.querosala.service;

import br.com.querosala.dto.ReservaCadastroDTO;
import br.com.querosala.dto.ReservaDTO;
import br.com.querosala.dto.SalaDTO;
import br.com.querosala.model.Reserva;
import br.com.querosala.model.Sala;
import br.com.querosala.repository.ReservaRepository;
import br.com.querosala.repository.SalaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final SalaRepository salaRepository;

    public ReservaService(
            ReservaRepository reservaRepository,
            SalaRepository salaRepository) {

        this.reservaRepository = reservaRepository;
        this.salaRepository = salaRepository;
    }

    public ReservaDTO cadastrarReserva(ReservaCadastroDTO dados){

        if (dados.dataHoraFim().isBefore(dados.dataHoraInicio())) {
            throw new IllegalArgumentException(
                    "A data final deve ser posterior à data inicial");
        }

        Sala sala = salaRepository.findById(dados.salaId())
                .orElseThrow();

        List<Reserva> reservasSala = reservaRepository.buscarReservasDaSala(sala.getId());

        Reserva novaReserva = new Reserva(
                dados.dataHoraInicio(),
                dados.dataHoraFim(),
                sala
        );

        boolean temConflito = reservasSala.stream()
                .anyMatch(reserva ->
                        novaReserva.getDataHoraInicio().isBefore(reserva.getDataHoraFim())
                                && novaReserva.getDataHoraFim().isAfter(reserva.getDataHoraInicio()));

        if (temConflito){
            throw new IllegalArgumentException("Sala estará indisponível no horário escolhido");
        }

        Reserva reservaSalva = reservaRepository.save(novaReserva);

        return new ReservaDTO(
                reservaSalva.getId(),
                reservaSalva.getSala().getNome(),
                reservaSalva.getDataHoraInicio(),
                reservaSalva.getDataHoraFim()
        );
    }

    public List<ReservaDTO> listarReservas() {
        return converterDadosParaDTO(reservaRepository.findAll());
    }

    public ReservaDTO buscarReservaPorId(Long id) {
        return reservaRepository.findById(id)
                .map(this::converterDadosParaDTO)
                .orElseThrow();
    }

    public void excluirReserva(Long id){
        if(!reservaRepository.existsById(id)){
            throw new IllegalArgumentException("Reserva não encontrada");
        }

        reservaRepository.deleteById(id);
    }

    private List<ReservaDTO> converterDadosParaDTO(List<Reserva> reservas){
        return reservas.stream()
                .map(r-> new ReservaDTO(
                        r.getId(),
                        r.getSala().getNome(),
                        r.getDataHoraInicio(),
                        r.getDataHoraFim()))
                .collect(Collectors.toList());
    }

    private ReservaDTO converterDadosParaDTO(Reserva reserva){
        return new ReservaDTO(
                reserva.getId(),
                reserva.getSala().getNome(),
                reserva.getDataHoraInicio(),
                reserva.getDataHoraFim()
        );
    }


}