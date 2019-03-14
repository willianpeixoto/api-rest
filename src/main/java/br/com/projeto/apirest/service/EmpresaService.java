package br.com.projeto.apirest.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

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
	
	public ResponseEntity<?> cadastrar(@RequestBody Empresa empresa, UriComponentsBuilder ucBuilder) {
		if(existe(empresa)) {
			return new ResponseEntity("Unable to create. A User with name " + empresa.getRazaoSocial() + " already exist.",HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/empresa/{id}").buildAndExpand(empresa.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
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

}
