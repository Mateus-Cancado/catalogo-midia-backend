package com.mateuscancado.catalogo_midia.mapper;

import com.mateuscancado.catalogo_midia.dto.ItemMidiaRequestDTO;
import com.mateuscancado.catalogo_midia.dto.ItemMidiaResponseDTO;
import com.mateuscancado.catalogo_midia.model.ItemMidia;
import org.springframework.stereotype.Component;

@Component
public class ItemMidiaMapper {

    public ItemMidia toEntity(ItemMidiaRequestDTO dto) {
        ItemMidia entity = new ItemMidia();
        entity.setTitulo(dto.titulo());
        entity.setAutorDiretor(dto.autorDiretor());
        entity.setAnoLancamento(dto.anoLancamento());
        entity.setGenero(dto.genero());
        entity.setSinopse(dto.sinopse());
        entity.setTipoMidia(dto.tipoMidia());
        return entity;
    }

    public ItemMidiaResponseDTO toResponse(ItemMidia entity) {
        return new ItemMidiaResponseDTO(
                entity.getId(),
                entity.getTitulo(),
                entity.getAutorDiretor(),
                entity.getAnoLancamento(),
                entity.getGenero(),
                entity.getSinopse(),
                entity.getTipoMidia());
    }
}
