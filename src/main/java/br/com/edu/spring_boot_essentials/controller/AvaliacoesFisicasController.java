package br.com.edu.spring_boot_essentials.controller;

import br.com.edu.spring_boot_essentials.database.model.ExerciciosEntity;
import br.com.edu.spring_boot_essentials.dto.AvaliacaoFisicaDto;
import br.com.edu.spring_boot_essentials.dto.AvaliacoesFisicasProjection;
import br.com.edu.spring_boot_essentials.dto.ExercicioDto;
import br.com.edu.spring_boot_essentials.exception.BadRequestException;
import br.com.edu.spring_boot_essentials.exception.NotFoundException;
import br.com.edu.spring_boot_essentials.service.AvaliacaoFisicaService;
import br.com.edu.spring_boot_essentials.service.ExerciciosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AvaliacoesFisicasProjection> getAllAvaliacoes(){
        return avaliacaoFisicaService.getAllAvaliacoes();
    }

    @GetMapping("/page/{page}/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public Page<AvaliacoesFisicasProjection> getAllAvaliacoes(@PathVariable Integer page,
                                                              @PathVariable Integer size){
        return avaliacaoFisicaService.getAllAvaliacoesPageable(page, size);
    }

    @DeleteMapping("aluno/{alunoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAvaliacao(@PathVariable Integer alunoId) throws NotFoundException{
        avaliacaoFisicaService.deleteAvaliacao(alunoId);

    }




}
