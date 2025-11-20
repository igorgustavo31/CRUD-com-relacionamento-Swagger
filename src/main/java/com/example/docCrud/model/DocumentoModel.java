package com.example.docCrud.model;

import jakarta.persistence.*;
import lombok.Data; // Apenas este import do lombok é necessário
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Data // Esta anotação sozinha é suficiente
public class DocumentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Lob
    private String conteudo;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    @JsonBackReference
    private CategoriaModel categoria;
}