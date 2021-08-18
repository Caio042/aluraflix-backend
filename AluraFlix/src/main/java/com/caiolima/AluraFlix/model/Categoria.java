package com.caiolima.AluraFlix.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Table (name = "tb_categoria")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class Categoria {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column (nullable = false)
    private String titulo;

    @Column (nullable = false)
    private String cor;
}
