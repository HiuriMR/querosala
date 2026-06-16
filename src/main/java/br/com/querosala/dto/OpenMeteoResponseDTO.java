package br.com.querosala.dto;

public record OpenMeteoResponseDTO(
        CurrentWeatherDTO current_weather,
        DailyDTO daily
) {}