package com.mateuscancado.catalogo_midia.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ItemMidiaRequestDTO(

        @NotNull(message = "O título não pode ser em branco.")
        @Size(min = 1, max = 255, message = "O título deve conter entre 1 e 255 caracteres.")
        String titulo,

        @NotNull(message = "O autor/diretor não pode ser em branco.")
        @Size(min = 1, max = 255, message = "O autor/diretor deve conter entre 1 e 255 caracteres.")
        String autorDiretor,

        @Min(value = 1888, message = "O ano de lançamento deve ser a partir de 1888.")
        @Max(value = 2100, message = "O ano de lançamento deve ser válido.")
        Integer anoLancamento,

        @Size(max = 100, message = "O gênero deve conter até 100 caracteres.")
        String genero,

        String sinopse,

        @NotNull(message = "O tipo de midia não pode ser em branco.")
        @Size(min = 1, max = 50, message = "O tipo de midia deve conter entre 1 e 50 caracteres.")
        String tipoMidia
) {}
