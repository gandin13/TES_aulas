package br.com.yasuo.maestria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.yasuo.maestria.entity.Personagem;
import br.com.yasuo.maestria.repository.PersongaemRepository;

@RestController
@RequestMapping("personagem")
public class PersonagemController {

	@Autowired
	private PersongaemRepository repository;
	
	
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Personagem> listAll(){
		Iterable<Personagem> list = repository.findAll();
		return list;		
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Personagem getById(@PathVariable Integer id) {
		Personagem personagem = repository.getOne(id);
		return personagem;
	}
	
	@PostMapping
	public Personagem add(@RequestBody @Valid Personagem personagem) {
		return repository.save(personagem);
	}
	
	@DeleteMapping("/{id}")
	public Personagem delete(@PathVariable Integer id) {
		Personagem personagem = repository.getOne(id);
		repository.delete(personagem);
		return personagem;
		
	}
}

