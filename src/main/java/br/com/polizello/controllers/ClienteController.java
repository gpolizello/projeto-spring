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

import br.com.polizello.entities.Cliente;
import br.com.polizello.repositories.ClienteRepository;

@RestController
@RequestMapping(value="/cliente", produces=MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/getClientes")
	@ResponseBody
	public List<Cliente> getClientes(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/getCliente/{id}")
	@ResponseBody
	public Optional<Cliente> getCliente(@PathVariable Long id){
		return clienteRepository.findById(id);
	}
	
	@PostMapping(value="/postCliente", consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Cliente> postCliente(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}
	
	@PutMapping(value="/putCliente", consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Cliente> putCliente(@RequestBody Cliente cliente){
		clienteRepository.save(cliente);
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCliente/{id}")
	@ResponseBody
	public void deleteCliente(@PathVariable Long id){
		clienteRepository.deleteById(id);
	}
}
