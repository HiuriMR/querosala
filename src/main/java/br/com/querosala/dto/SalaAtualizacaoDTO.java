package br.com.querosala.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SalaAtualizacaoDTO(

        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotNull(message = "Capacidade é obrigatória")
        @Min(value = 1, message = "Capacidade deve ser maior que zero")
        Integer capacidade,

        @NotNull(message = "Andar é obrigatório")
        @Min(value = 0, message = "Andar deve ser maior ou igual a zero")
        Integer andar

) {}