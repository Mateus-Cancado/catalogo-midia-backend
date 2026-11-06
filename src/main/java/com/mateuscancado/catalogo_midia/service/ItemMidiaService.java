package com.mateuscancado.catalogo_midia.service;

import com.mateuscancado.catalogo_midia.dto.ItemMidiaRequestDTO;
import com.mateuscancado.catalogo_midia.dto.ItemMidiaResponseDTO;
import com.mateuscancado.catalogo_midia.mapper.ItemMidiaMapper;
import com.mateuscancado.catalogo_midia.model.ItemMidia;
import com.mateuscancado.catalogo_midia.repository.ItemMidiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemMidiaService {

    private final ItemMidiaRepository itemMidiaRepository;
    private final ItemMidiaMapper itemMidiaMapper;

    public ItemMidiaResponseDTO salvar(ItemMidiaRequestDTO dto) {
        ItemMidia salvo = itemMidiaRepository.save(itemMidiaMapper.toEntity(dto));
        return itemMidiaMapper.toResponse(salvo);
    }
}
