package br.com.querosala.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ReservaAtualizacaoDTO(

        @NotNull
        Long salaId,

        @NotNull
        LocalDateTime dataHoraInicio,

        @NotNull
        LocalDateTime dataHoraFim

) {}