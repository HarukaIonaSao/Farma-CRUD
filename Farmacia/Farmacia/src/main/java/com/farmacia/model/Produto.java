package com.farmacia.model;

import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;//primary key
	
	@NotBlank(message = "Por favor, digite o nome do produto")
	@Size(min = 2, max = 100, message = "Por favor, digite pelo menos dois caracteres!!!")
	private String nome;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull(message = "O preço é obrigatório!")
    @Positive(message = "O preço deve ser maior do que zero!")
    private BigDecimal preco;
	
	@NotBlank(message = "Informe o fabricante!")
	@Size(min = 2, max = 100, message = "Por favor, digite pelo menos dois caracteres!!!")
	private String fabricante;
		
	@NotNull(message = "Por favor, informe a quantidade")
	private Integer quantidade;
	

	@NotBlank(message = "Por favor,informe a descrição!")
	@Size(min = 2, max = 100, message = "Por favor, digite pelo menos dois caracteres!!!")
	private String descricao;
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("produto")
	private List<Produto> produto;
	
}
