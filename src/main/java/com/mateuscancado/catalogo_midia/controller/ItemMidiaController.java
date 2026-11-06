package com.mateuscancado.catalogo_midia.controller;

import com.mateuscancado.catalogo_midia.dto.ItemMidiaRequestDTO;
import com.mateuscancado.catalogo_midia.dto.ItemMidiaResponseDTO;
import com.mateuscancado.catalogo_midia.service.ItemMidiaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/midia")
@RequiredArgsConstructor
public class ItemMidiaController {

    private final ItemMidiaService itemMidiaService;

    @PostMapping
    public ResponseEntity<ItemMidiaResponseDTO> salvar(@Valid @RequestBody ItemMidiaRequestDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(itemMidiaService.salvar(dto));
    }
}
