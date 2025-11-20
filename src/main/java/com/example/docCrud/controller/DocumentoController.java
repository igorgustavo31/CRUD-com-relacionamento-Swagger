package com.example.docCrud.controller;

import com.example.docCrud.exception.ResourceNotFoundException;
import com.example.docCrud.model.CategoriaModel;
import com.example.docCrud.model.DocumentoModel;
import com.example.docCrud.repository.CategoriaRepository;
import com.example.docCrud.repository.DocumentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {

    private final DocumentoRepository documentoRepository;
    private final CategoriaRepository categoriaRepository;

    public DocumentoController(DocumentoRepository documentoRepository, CategoriaRepository categoriaRepository) {
        this.documentoRepository = documentoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    // 🟢 GET - Listar todos os documentos
    @GetMapping
    public List<DocumentoModel> all() {
        return documentoRepository.findAll();
    }

    // 🟢 GET - Buscar documento por ID
    @GetMapping("/{id}")
    public DocumentoModel getById(@PathVariable Long id) {
        return documentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Documento não encontrado com ID: " + id));
    }

    // 🟢 POST - Criar novo documento
    @PostMapping
    public ResponseEntity<DocumentoModel> create(@RequestBody DocumentoModel documento) {
        if (documento.getCategoria() != null && documento.getCategoria().getId() != null) {
            CategoriaModel categoria = categoriaRepository.findById(documento.getCategoria().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com ID: " + documento.getCategoria().getId()));
            documento.setCategoria(categoria);
        }
        DocumentoModel saved = documentoRepository.save(documento);
        return ResponseEntity.created(URI.create("/api/documentos/" + saved.getId())).body(saved);
    }

    // 🟢 PUT - Atualizar documento existente
    @PutMapping("/{id}")
    public DocumentoModel update(@PathVariable Long id, @RequestBody DocumentoModel documento) {
        DocumentoModel existing = documentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Documento não encontrado com ID: " + id));

        existing.setTitulo(documento.getTitulo());
        existing.setConteudo(documento.getConteudo());

        if (documento.getCategoria() != null && documento.getCategoria().getId() != null) {
            CategoriaModel categoria = categoriaRepository.findById(documento.getCategoria().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com ID: " + documento.getCategoria().getId()));
            existing.setCategoria(categoria);
        } else {
            existing.setCategoria(null);
        }

        return documentoRepository.save(existing);
    }

    // 🟢 DELETE - Deletar documento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        DocumentoModel existing = documentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Documento não encontrado com ID: " + id));

        documentoRepository.delete(existing);
        return ResponseEntity.noContent().build();
    }
}
