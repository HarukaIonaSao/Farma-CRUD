package com.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.model.Categoria;


	@Repository
	public interface ProdutoInterface extends JpaRepository<Categoria, Long> {
	public List<Categoria> findAllByMedicamentoContainingIgnoreCase(String medicamentos);
	}


