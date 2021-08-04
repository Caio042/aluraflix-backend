package com.caiolima.AluraFlix.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {

    private Long id;

    @NotBlank
    @Size (min = 5, max = 30)
    private String titulo;

    @NotBlank
    @Size (min = 2, max = 10)
    // Todo pattern
    private String cor;
}
