package com.caiolima.AluraFlix.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoDTO {

	private long id;
	
	@NotBlank
	@Size (max = 30)
	private String titulo;
	
	@NotBlank
	@Size (max = 300)
	private String descricao;
	
	@NotBlank
	@URL
	@Size (max = 1000)
	private String url;

}