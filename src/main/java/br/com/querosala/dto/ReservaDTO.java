package br.com.querosala.dto;

import java.time.LocalDateTime;

public record ReservaDTO(
        Long id,
        String nomeSala,
        LocalDateTime dataHoraInicio,
        LocalDateTime dataHoraFim
) {}
