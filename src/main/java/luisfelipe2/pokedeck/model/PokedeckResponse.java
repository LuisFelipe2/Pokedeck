package luisfelipe2.pokedeck.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PokedeckResponse {
	@Id
	private String pokemonName;
	private int quantidade;

	public String getPokemonName() {
		return pokemonName;
	}

	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
