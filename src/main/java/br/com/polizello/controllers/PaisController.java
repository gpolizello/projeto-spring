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

import br.com.polizello.entities.Pais;
import br.com.polizello.repositories.PaisRepository;

@RestController
@RequestMapping(value="/pais", produces=MediaType.APPLICATION_JSON_VALUE)
public class PaisController {
	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping("/getPaises")
	@ResponseBody
	public List<Pais> getPaises(){
		return paisRepository.findAll();
	}
	
	@GetMapping("/getPais/{id}")
	@ResponseBody
	public Optional<Pais> getPais(@PathVariable Long id){
		return paisRepository.findById(id);
	}
	
	@PostMapping(value="/postPais", consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Pais> postPais(@RequestBody Pais pais) {
		paisRepository.save(pais);
		return new ResponseEntity<Pais>(HttpStatus.OK);
	}
	
	@PutMapping(value="/putPais", consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Pais> putPais(@RequestBody Pais pais){
		paisRepository.save(pais);
		return new ResponseEntity<Pais>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePais/{id}")
	@ResponseBody
	public void deletePais(@PathVariable Long id){
		paisRepository.deleteById(id);
	}
}
