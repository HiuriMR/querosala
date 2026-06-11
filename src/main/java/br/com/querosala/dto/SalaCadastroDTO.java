package br.com.querosala.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SalaCadastroDTO(
        @NotBlank(message = "O nome não pode ser branco")
        String nome,
        @NotNull(message = "Capacidade é obrigatória")
        @Min(value = 1, message = "Capacidade não pode ser menor que 1")
        Integer capacidade,
        @NotNull(message = "Andar é obrigatório")
        @Min(value = 0, message = "Andar não pode ser menor que 0")
        Integer andar
) {}
