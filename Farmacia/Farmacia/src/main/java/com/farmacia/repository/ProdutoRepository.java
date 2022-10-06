package com.farmacia.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.farmacia.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {	

	public List <Produto> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
	public List <Produto> findAllByPreco(@Param("preco") BigDecimal preco);
	public List <Produto> findAllByFabricanteContainingIgnoreCase(@Param("fabricante") String fabricante);
	public List <Produto> findAllByQuantidade(@Param("quantidade") Integer quantidade);
	public List <Produto> findAllByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);
}
