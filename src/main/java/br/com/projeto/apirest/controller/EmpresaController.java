package br.com.projeto.apirest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.apirest.entity.Empresa;
import br.com.projeto.apirest.service.EmpresaService;

@RestController
@RequestMapping("api/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping(value="/{id}")
	public Optional<Empresa> buscarEmpresaPorId(@PathVariable("id") Long id) {
		return empresaService.buscarPorId(id);
	}
	
	@GetMapping(value="/")
	public List<Empresa> listarEmpresas() {
		return empresaService.listar();
	}
	
	@PostMapping(value="/")
	public ResponseEntity<String> cadastrarEmpresa(@Valid @RequestBody Empresa empresa) {
		return empresaService.salvar(empresa);
	}
	
	@PutMapping(value="/{id}")
	public void cadastrarEmpresa(@PathVariable("id")Long id) {
		//empresaService.salvar(empresa);
	}
	
	@DeleteMapping(value="/{id}")
	public void deletarEmpresa(@PathVariable("id")Long id) {
		empresaService.deletarPorId(id);
	}
	
	


}
