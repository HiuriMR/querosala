package br.com.querosala.service;

import br.com.querosala.dto.ClimaDTO;
import br.com.querosala.dto.CurrentWeatherDTO;
import br.com.querosala.dto.OpenMeteoResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ClimaService {

    private final RestClient restClient;

    public ClimaService(RestClient restClient) {
        this.restClient = restClient;
    }

    public ClimaDTO obterClimaAtual(){
        //chama a api
        OpenMeteoResponseDTO resposta = restClient.get()
                .uri("https://api.open-meteo.com/v1/forecast?latitude=-23.53&longitude=-46.79&current_weather=true")
                .retrieve()
                .body(OpenMeteoResponseDTO.class);
        //validar resposta da api
        if (resposta == null || resposta.current_weather() == null) {
            throw new IllegalStateException(
                    "Não foi possível obter dados climáticos");
        }

        //converte para DTO
        CurrentWeatherDTO clima = resposta.current_weather();
        //retorna o clima
        return new ClimaDTO(
                clima.temperature(),
                clima.windspeed()
        );
    }
}