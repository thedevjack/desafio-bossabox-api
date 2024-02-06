package com.devjack.desafiobossabox.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_tools", schema = "desafios")
public class Tools implements Serializable {

    @Id
    @Column(columnDefinition = "bigserial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    private String link;

    private List<String> tags;


    public Tools(String titulo, String descricao, String link, List<String> tags) {
       this.titulo = titulo;
       this.descricao = descricao;
       this.link = link;
       this.tags = tags;
    }
}
