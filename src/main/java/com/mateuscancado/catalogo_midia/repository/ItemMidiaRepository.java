package com.mateuscancado.catalogo_midia.repository;

import com.mateuscancado.catalogo_midia.model.ItemMidia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemMidiaRepository extends JpaRepository<ItemMidia, Long> {

    @Query("SELECT i FROM ItemMidia i WHERE LOWER(i.titulo) LIKE LOWER(CONCAT('%', :tituloOrAutor, '%')) OR LOWER(i.autorDiretor) LIKE LOWER(CONCAT('%', :tituloOrAutor, '%'))")
    List<ItemMidia> findByTituloOrAutor(@Param("tituloOrAutor") String tituloOrAutor);
}
