package com.mateuscancado.catalogo_midia.controller;

import com.mateuscancado.catalogo_midia.dto.FilterRequestDTO;
import com.mateuscancado.catalogo_midia.dto.ItemMidiaRequestDTO;
import com.mateuscancado.catalogo_midia.dto.ItemMidiaResponseDTO;
import com.mateuscancado.catalogo_midia.service.ItemMidiaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
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

    @PostMapping("/filtro")
    public ResponseEntity<List<ItemMidiaResponseDTO>> buscarFiltro(@Valid @RequestBody FilterRequestDTO dto) {
        return ResponseEntity
                .ok(itemMidiaService.buscarFiltro(dto));
    }

    @GetMapping
    public ResponseEntity<Page<ItemMidiaResponseDTO>> buscarTodos(Pageable pageable) {
        return ResponseEntity
                .ok(itemMidiaService.buscarTodos(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemMidiaResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ItemMidiaRequestDTO dto) {
        return ResponseEntity.ok(itemMidiaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        itemMidiaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
