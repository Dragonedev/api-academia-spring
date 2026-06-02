package br.com.edu.spring_boot_essentials.controller;

import br.com.edu.spring_boot_essentials.database.model.AlunosEntity;
import br.com.edu.spring_boot_essentials.database.model.AvaliacoesFisicasEntity;
import br.com.edu.spring_boot_essentials.database.model.ExerciciosEntity;
import br.com.edu.spring_boot_essentials.dto.AlunoDto;
import br.com.edu.spring_boot_essentials.dto.ExercicioDto;
import br.com.edu.spring_boot_essentials.exception.BadRequestException;
import br.com.edu.spring_boot_essentials.exception.NotFoundException;
import br.com.edu.spring_boot_essentials.service.AlunosService;
import br.com.edu.spring_boot_essentials.service.ExerciciosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/alunos")
@RequiredArgsConstructor
@Validated
public class AlunosController {

    private final AlunosService alunosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAluno(@Valid @RequestBody AlunoDto alunoDto) throws BadRequestException {
        alunosService.criarAluno(alunoDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlunosEntity> findAll(){
        return alunosService.findAll();
    }

    @GetMapping("/{alunoId}/avaliacao")
    @ResponseStatus(HttpStatus.OK)
    public AvaliacoesFisicasEntity getAvaliacaoFisica(@PathVariable Integer alunoId) throws NotFoundException {
        return alunosService.getAlunoAvaliacao(alunoId);
    }

    @DeleteMapping("/{alunoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerAluno(@PathVariable Integer alunoId) throws NotFoundException{
        alunosService.deletarAluno(alunoId);
    }



}
