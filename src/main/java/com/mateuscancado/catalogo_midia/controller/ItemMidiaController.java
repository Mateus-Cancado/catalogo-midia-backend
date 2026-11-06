package com.mateuscancado.catalogo_midia.controller;

import com.mateuscancado.catalogo_midia.model.ItemMidia;
import com.mateuscancado.catalogo_midia.service.ItemMidiaService;
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
    public ResponseEntity<ItemMidia> salvar(@RequestBody ItemMidia itemMidia) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(itemMidiaService.salvar(itemMidia));
    }
}
