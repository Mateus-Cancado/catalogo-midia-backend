package com.mateuscancado.catalogo_midia.service;

import com.mateuscancado.catalogo_midia.dto.FilterRequestDTO;
import com.mateuscancado.catalogo_midia.dto.ItemMidiaRequestDTO;
import com.mateuscancado.catalogo_midia.dto.ItemMidiaResponseDTO;
import com.mateuscancado.catalogo_midia.mapper.ItemMidiaMapper;
import com.mateuscancado.catalogo_midia.model.ItemMidia;
import com.mateuscancado.catalogo_midia.repository.ItemMidiaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemMidiaService {

    private final ItemMidiaRepository itemMidiaRepository;
    private final ItemMidiaMapper itemMidiaMapper;

    public ItemMidiaResponseDTO salvar(ItemMidiaRequestDTO dto) {
        ItemMidia salvo = itemMidiaRepository.save(itemMidiaMapper.toEntity(dto));
        return itemMidiaMapper.toResponse(salvo);
    }

    public ItemMidiaResponseDTO buscar(Long id) {
        ItemMidia item = itemMidiaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return itemMidiaMapper.toResponse(item);
    }

    public List<ItemMidiaResponseDTO> buscarFiltro(FilterRequestDTO dto) {
        List<ItemMidia> list = itemMidiaRepository.findByTituloOrAutor(dto.tituloOrAutorDiretor());
        return itemMidiaMapper.toResponseList(list);
    }
}
