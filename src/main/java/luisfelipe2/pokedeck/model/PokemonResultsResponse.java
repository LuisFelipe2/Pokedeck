package luisfelipe2.pokedeck.model;

import java.util.List;

public class PokemonResultsResponse {
	private List<PokemonResponse> results;

	public List<PokemonResponse> getResults() {
		return results;
	}

	public void setResults(List<PokemonResponse> results) {
		this.results = results;
	}
}
