package luisfelipe2.pokedeck.repository;

import luisfelipe2.pokedeck.model.PokedeckResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokedeckRepository extends JpaRepository<PokedeckResponse, String> {
}
