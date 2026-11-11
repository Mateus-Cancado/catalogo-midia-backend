package com.mateuscancado.catalogo_midia.service;

import com.mateuscancado.catalogo_midia.dto.FilterRequestDTO;
import com.mateuscancado.catalogo_midia.dto.ItemMidiaRequestDTO;
import com.mateuscancado.catalogo_midia.dto.ItemMidiaResponseDTO;
import com.mateuscancado.catalogo_midia.exceptions.MidiaNaoEncontradaException;
import com.mateuscancado.catalogo_midia.mapper.ItemMidiaMapper;
import com.mateuscancado.catalogo_midia.model.ItemMidia;
import com.mateuscancado.catalogo_midia.repository.ItemMidiaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        ItemMidia item = buscarEntidadePorId(id);
        return itemMidiaMapper.toResponse(item);
    }

    public List<ItemMidiaResponseDTO> buscarFiltro(FilterRequestDTO dto) {
        List<ItemMidia> lista = itemMidiaRepository.findByTituloOrAutor(dto.tituloOrAutorDiretor());
        return itemMidiaMapper.toResponseList(lista);
    }

    public Page<ItemMidiaResponseDTO> buscarTodos(Pageable pageable) {
        Page<ItemMidia> paginaEntities = itemMidiaRepository.findAll(pageable);
        return paginaEntities.map(itemMidiaMapper::toResponse);
    }

    public ItemMidiaResponseDTO atualizar(Long id, ItemMidiaRequestDTO dto) {
        ItemMidia item = buscarEntidadePorId(id);
        item.setTitulo(dto.titulo());
        item.setAutorDiretor(dto.autorDiretor());
        item.setAnoLancamento(dto.anoLancamento());
        item.setGenero(dto.genero());
        item.setSinopse(dto.sinopse());
        item.setTipoMidia(dto.tipoMidia());
        return itemMidiaMapper.toResponse(itemMidiaRepository.save(item));
    }

    public void deletar(Long id) {
        itemMidiaRepository.deleteById(id);
    }

    private ItemMidia buscarEntidadePorId(Long id) {
        return itemMidiaRepository.findById(id).orElseThrow(MidiaNaoEncontradaException::new);
    }
}
