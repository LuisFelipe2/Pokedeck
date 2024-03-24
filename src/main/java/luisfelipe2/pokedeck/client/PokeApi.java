package luisfelipe2.pokedeck.client;

import luisfelipe2.pokedeck.model.PokemonResultsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "pokeApi", url = "https://pokeapi.co/api")
public interface PokeApi {

	@GetMapping("/v2/pokemon?limit=10")
	PokemonResultsResponse getPokemonByPokeApi();
}
