package com.example.docCrud.repository;

import com.example.docCrud.model.DocumentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<DocumentoModel, Long> {
}
