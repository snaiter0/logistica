package br.sp.oz.portal.logistica.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sp.oz.portal.logistica.service.resources.entitys.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long>{

}
