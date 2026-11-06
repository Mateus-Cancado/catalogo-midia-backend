package com.mateuscancado.catalogo_midia.service;

import com.mateuscancado.catalogo_midia.model.ItemMidia;
import com.mateuscancado.catalogo_midia.repository.ItemMidiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemMidiaService {

    private final ItemMidiaRepository itemMidiaRepository;

    public ItemMidia salvar(ItemMidia itemMidia) {
        return itemMidiaRepository.save(itemMidia);
    }
}
