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

import br.com.polizello.entities.Usuario;
import br.com.polizello.repositories.UsuarioRepository;

@RestController
@RequestMapping(value="/usuario", produces=MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/getUsuarios")
	@ResponseBody
	public List<Usuario> getUsuarios(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/getUsuario/{id}")
	@ResponseBody
	public Optional<Usuario> getUsuario(@PathVariable Long id){
		return usuarioRepository.findById(id);
	}
	
	@PostMapping(value="/postUsuario", consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario) {
		usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}
	
	@PutMapping(value="/putUsuario", consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Usuario> putUsuario(@RequestBody Usuario usuario){
		usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUsuario/{id}")
	@ResponseBody
	public void deleteUsuario(@PathVariable Long id){
		usuarioRepository.deleteById(id);
	}
}
