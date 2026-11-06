package com.mateuscancado.catalogo_midia.dto;

public record ItemMidiaResponseDTO(
        Long id,
        String titulo,
        String autorDiretor,
        Integer anoLancamento,
        String genero,
        String sinopse,
        String tipoMidia
) {
}
