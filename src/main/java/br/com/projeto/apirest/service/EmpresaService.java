package br.com.projeto.apirest.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.projeto.apirest.entity.Empresa;
import br.com.projeto.apirest.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Optional<Empresa> buscarPorId(Long id) {
		return empresaRepository.findById(id);
	}
	
	public List<Empresa> listar() {
		return empresaRepository.findAll();
	}
	
	public ResponseEntity<String> salvar(@RequestBody Empresa empresa) {
		if(existe(empresa)) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		empresaRepository.save(empresa);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	public ResponseEntity<String> atualizar(@RequestBody Empresa empresa) {
		if(Objects.nonNull(empresa) && Objects.nonNull(empresa.getId())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		empresaRepository.save(empresa);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	private	Boolean existe(Empresa empresa) {
		if(Objects.nonNull(empresa) && Objects.nonNull(empresa.getId())) {
			Optional<Empresa> empresaRetorno = empresaRepository.findById(empresa.getId());
			if(Objects.nonNull(empresaRetorno)) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	public void deletarPorId(Long id) {
		empresaRepository.deleteById(id);
	}

}
