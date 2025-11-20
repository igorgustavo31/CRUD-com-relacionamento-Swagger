package com.example.docCrud.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Data; // Apenas este import é necessário
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data // Esta anotação sozinha é suficiente
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<DocumentoModel> documentos = new ArrayList<>();
}