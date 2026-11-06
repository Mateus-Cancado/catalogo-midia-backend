package com.mateuscancado.catalogo_midia.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "item_midia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ItemMidia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(name = "autor_diretor", nullable = false)
    private String autorDiretor;

    @Column(name = "ano_lancamento")
    private Integer anoLancamento;

    private String genero;

    @Column(columnDefinition = "TEXT")
    private String sinopse;

    @Column(name = "tipo_midia", nullable = false)
    private String tipoMidia;
}
