package br.com.projeto.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.apirest.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	
	Empresa findByCnpj(String cnpj);

}
