package com.caiolima.AluraFlix.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tb_video")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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