package br.sp.oz.base.arquitetura.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sp.oz.base.arquitetura.service.resources.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{

}
