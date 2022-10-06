package com.farmacia.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_Categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "É obrigatório adicionar uma categoria!!!")
	
	private String medicamentos;
	
	@NotBlank(message = "É obrigatório adicionar uma categoria!!!")
	private String cuidadosdiarios;
	
	@NotBlank(message = "É obrigatório adicionar uma categoria!!!")
	private String suplementosalimentares;
	
	@NotBlank(message = "É obrigatório adicionar uma categoria!!!")
	private String promocoes;
	
	@UpdateTimestamp
	private LocalDateTime data;

	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Categoria> categoria;

}
