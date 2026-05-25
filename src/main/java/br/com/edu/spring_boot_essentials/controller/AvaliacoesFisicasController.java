package br.com.edu.spring_boot_essentials.controller;

import br.com.edu.spring_boot_essentials.database.model.ExerciciosEntity;
import br.com.edu.spring_boot_essentials.dto.AvaliacaoFisicaDto;
import br.com.edu.spring_boot_essentials.dto.ExercicioDto;
import br.com.edu.spring_boot_essentials.exception.BadRequestException;
import br.com.edu.spring_boot_essentials.exception.NotFoundException;
import br.com.edu.spring_boot_essentials.service.AvaliacaoFisicaService;
import br.com.edu.spring_boot_essentials.service.ExerciciosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/avaliacoes")
@RequiredArgsConstructor
@Validated
public class AvaliacoesFisicasController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAvaliacaoFisica(@Valid @RequestBody AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException {
        avaliacaoFisicaService.criarAvaliacaoFisica(avaliacaoFisicaDto);
    }


}
