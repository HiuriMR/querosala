package br.com.querosala.dto;

import br.com.querosala.model.Sala;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ReservaCadastroDTO(
        @NotNull(message = "Id da sala é obrigatória")
        Long salaId,
        @NotNull(message = "Data e hora de início é obrigatória")
        LocalDateTime dataHoraInicio,
        @NotNull(message = "Data e hora do fim é obrigatória")
        LocalDateTime dataHoraFim
) {}
