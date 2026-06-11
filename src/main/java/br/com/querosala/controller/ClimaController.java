package br.com.querosala.controller;

import br.com.querosala.dto.ClimaDTO;
import br.com.querosala.service.ClimaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clima")
public class ClimaController {

    private final ClimaService climaService;

    public ClimaController(ClimaService climaService) {
        this.climaService = climaService;
    }

    @GetMapping
    public ClimaDTO obterClimaAtual() {
        return climaService.obterClimaAtual();
    }
}