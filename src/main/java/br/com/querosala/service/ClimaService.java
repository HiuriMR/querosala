package br.com.querosala.service;

import br.com.querosala.dto.ClimaDTO;
import br.com.querosala.dto.CurrentWeatherDTO;
import br.com.querosala.dto.OpenMeteoResponseDTO;
import br.com.querosala.dto.PrevisaoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClimaService {

    private final RestClient restClient;

    public ClimaService(RestClient restClient) {
        this.restClient = restClient;
    }

    public ClimaDTO obterClimaAtual(){
        //chama a api
        OpenMeteoResponseDTO resposta = restClient.get()
                //.uri("https://api.open-meteo.com/v1/forecast?latitude=-23.53&longitude=-46.79&current_weather=true")
                .uri("https://api.open-meteo.com/v1/forecast?latitude=-23.53&longitude=-46.79&current_weather=true&daily=temperature_2m_max,temperature_2m_min&forecast_days=7&timezone=America/Sao_Paulo")
                .retrieve()
                .body(OpenMeteoResponseDTO.class);
        //validar resposta da api
        if (resposta == null || resposta.current_weather() == null) {
            throw new IllegalStateException(
                    "Não foi possível obter dados climáticos");
        }

        //converte para DTO
        CurrentWeatherDTO clima = resposta.current_weather();

        List<PrevisaoDTO> previsoes =
                new ArrayList<>();

        for(int i = 0; i < resposta.daily().time().size(); i++){

            previsoes.add(
                    new PrevisaoDTO(
                            resposta.daily().time().get(i),
                            resposta.daily().temperature_2m_max().get(i),
                            resposta.daily().temperature_2m_min().get(i)
                    )
            );
        }
        //retorna o clima
        return new ClimaDTO(
                clima.temperature(),
                clima.windspeed(),
                previsoes
        );
    }
}