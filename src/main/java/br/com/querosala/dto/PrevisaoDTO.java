package br.com.querosala.dto;

public record PrevisaoDTO(
        String data,
        Double temperaturaMaxima,
        Double temperaturaMinima
) {}