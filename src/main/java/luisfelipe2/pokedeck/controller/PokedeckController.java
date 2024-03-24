package luisfelipe2.pokedeck.controller;

import luisfelipe2.pokedeck.model.PokedeckResponse;
import luisfelipe2.pokedeck.repository.PokedeckRepository;
import luisfelipe2.pokedeck.service.PokedeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PokedeckController {

	@Autowired
	private PokedeckRepository repository;
	@Autowired
	private PokedeckService service;

	@GetMapping
	public List<PokedeckResponse> getPokedeck() {
		return repository.findAll();
	}
	@GetMapping("/{name}")
	public PokedeckResponse getPokemon(@PathVariable String name) {
		return service.buscarPokemon(name);
	}

	@PostMapping("/{name}")
	public PokedeckResponse postPokemon(@PathVariable String name) {
		return service.gravarPokemon(name);
	}

	@DeleteMapping("/{name}")
	public PokedeckResponse deletePokemon(@PathVariable String name) {
		return service.removerPokemon(name);
	}
}
