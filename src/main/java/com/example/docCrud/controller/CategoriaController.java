package com.example.docCrud.controller;

import com.example.docCrud.exception.ResourceNotFoundException;
import com.example.docCrud.model.CategoriaModel;
import com.example.docCrud.repository.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
    public List<CategoriaModel> all() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public CategoriaModel getById(@PathVariable Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada: " + id));
    }

    @PostMapping
    public ResponseEntity<CategoriaModel> create(@Validated @RequestBody CategoriaModel categoria) {
        CategoriaModel saved = categoriaRepository.save(categoria);
        return ResponseEntity.created(URI.create("/api/categorias/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaModel> update(@PathVariable Long id, @RequestBody CategoriaModel categoria) {
        CategoriaModel existing = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada: " + id));

        existing.setNome(categoria.getNome());

        CategoriaModel updated = categoriaRepository.save(existing);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        CategoriaModel existing = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada: " + id));
        categoriaRepository.delete(existing);
        return ResponseEntity.noContent().build();
    }
}
