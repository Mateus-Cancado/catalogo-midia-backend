package com.mateuscancado.catalogo_midia.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record FilterRequestDTO(
        @NotNull(message = "O título ou autor/diretor não pode ser em branco.")
        @Size(min = 1, max = 255, message = "O título ou autor/diretor deve conter entre 1 e 255 caracteres.")
        String tituloOrAutorDiretor
) {}
