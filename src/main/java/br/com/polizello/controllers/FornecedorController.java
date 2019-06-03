package br.com.polizello.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.polizello.entities.Fornecedor;
import br.com.polizello.repositories.FornecedorRepository;

@RestController
@RequestMapping(value="/fornecedor", produces=MediaType.APPLICATION_JSON_VALUE)
public class FornecedorController {
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@GetMapping("/getFornecedores")
	@ResponseBody
	public List<Fornecedor> getFornecedores(){
		return fornecedorRepository.findAll();
	}
	
	@GetMapping("/getFornecedor/{id}")
	@ResponseBody
	public Optional<Fornecedor> getFornecedor(@PathVariable Long id){
		return fornecedorRepository.findById(id);
	}
	
	@PostMapping(value="/postFornecedor", consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Fornecedor> postFornecedor(@RequestBody Fornecedor fornecedor) {
		fornecedorRepository.save(fornecedor);
		return new ResponseEntity<Fornecedor>(HttpStatus.OK);
	}
	
	@PutMapping(value="/putFornecedor", consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Fornecedor> putFornecedor(@RequestBody Fornecedor fornecedor){
		fornecedorRepository.save(fornecedor);
		return new ResponseEntity<Fornecedor>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteFornecedor/{id}")
	@ResponseBody
	public void deleteFornecedor(@PathVariable Long id){
		fornecedorRepository.deleteById(id);
	}
}
