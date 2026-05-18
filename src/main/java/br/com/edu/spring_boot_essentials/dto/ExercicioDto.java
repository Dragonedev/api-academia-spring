package br.com.edu.spring_boot_essentials.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ExercicioDto {

    @NotBlank //Not Null or Empty
    private String nome;
    @NotBlank
    private String grupoMuscular;
}
