package com.mateuscancado.catalogo_midia.controller;

import com.mateuscancado.catalogo_midia.dto.FilterRequestDTO;
import com.mateuscancado.catalogo_midia.dto.ItemMidiaRequestDTO;
import com.mateuscancado.catalogo_midia.dto.ItemMidiaResponseDTO;
import com.mateuscancado.catalogo_midia.service.ItemMidiaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<ItemMidiaResponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity
                .ok(itemMidiaService.buscar(id));
    }

    @GetMapping
    public ResponseEntity<List<ItemMidiaResponseDTO>> buscarFiltro(@Valid @RequestBody FilterRequestDTO dto) {
        return ResponseEntity
                .ok(itemMidiaService.buscarFiltro(dto));
    }
}
