package luisfelipe2.pokedeck.service;

import luisfelipe2.pokedeck.client.PokeApi;
import luisfelipe2.pokedeck.model.PokedeckResponse;
import luisfelipe2.pokedeck.model.PokemonResponse;
import luisfelipe2.pokedeck.repository.PokedeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokedeckService {

	@Autowired
	private PokedeckRepository repository;
	@Autowired
	private PokeApi pokeApi;
	public PokedeckResponse buscarPokemon(String name) {
		if (verificaSePokemonExiste(name)){
			return consultaPokemonNaBase(name);
		} else {
			return null;
		}
	}

	public PokedeckResponse gravarPokemon(String name) {
		if (verificaSePokemonExiste(name)) {
			PokedeckResponse response = consultaPokemonNaBase(name);

			if (response != null) {
				response.setQuantidade(response.getQuantidade() + 1);
				return repository.save(response);
			} else {
				PokedeckResponse newPokedec = new PokedeckResponse();
				newPokedec.setPokemonName(name);
				newPokedec.setQuantidade(1);

				return repository.save(newPokedec);
			}
		} else {
			return null;
		}
	}

	public PokedeckResponse removerPokemon(String name) {
		if (verificaSePokemonExiste(name)) {
			PokedeckResponse response = consultaPokemonNaBase(name);

			if (response != null) {
				response.setQuantidade(response.getQuantidade() - 1);

				if (response.getQuantidade() == 0) {
					repository.delete(response);
					return response;
				} else {
					return repository.save(response);
				}
			}
		}
		return null;
	}
	private PokedeckResponse consultaPokemonNaBase(String name) {
		return repository.findById(name).orElse(null);
	}

	private boolean verificaSePokemonExiste(String name) {
		List<PokemonResponse> pokemons = pokeApi.getPokemonByPokeApi().getResults();

		for (PokemonResponse pokemon : pokemons) {
			if (name.equals(pokemon.getName())) {
				return true;
			}
		}
		return false;
	}
}
