package br.com.querosala.dto;

import jakarta.persistence.Column;

public record SalaDTO(
        Long id,
        String nome,
        Integer capacidade,
        Integer andar
) {}
