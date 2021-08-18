package com.caiolima.AluraFlix.model;

import javax.persistence.*;

import lombok.*;


@Entity
@Table(name = "tb_video")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column (nullable = false)
	private String titulo;
	
	@Column (nullable = false)
	private String descricao;
	
	@Column (nullable = false, unique = true)
	private String url;

	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "categoria_id")
	private Categoria categoria;


}