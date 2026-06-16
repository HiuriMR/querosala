package br.com.querosala.dto;

import java.util.List;

public record ClimaDTO(
        Double temperatura,
        Double velocidadeVento,
        List<PrevisaoDTO> previsao
) {}