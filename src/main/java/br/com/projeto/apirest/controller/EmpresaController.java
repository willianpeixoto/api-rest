package br.com.projeto.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.projeto.apirest.entity.Empresa;
import br.com.projeto.apirest.service.EmpresaService;

@RestController
@RequestMapping("api/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping(value="/{id}")
	public Optional<Empresa> buscarEmpresaPorId(@PathVariable("id")Long id) {
		return empresaService.buscarPorId(id);
	}
	
	@GetMapping(value="/")
	public List<Empresa> listarEmpresas() {
		return empresaService.listar();
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<?> cadastrarEmpresa(@RequestBody Empresa empresa, UriComponentsBuilder ucBuilder) {
		return empresaService.cadastrar(empresa, ucBuilder);
	}

}
