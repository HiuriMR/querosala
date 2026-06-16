package br.com.querosala.dto;

import java.util.List;

public record DailyDTO(
        List<String> time,
        List<Double> temperature_2m_max,
        List<Double> temperature_2m_min
) {}