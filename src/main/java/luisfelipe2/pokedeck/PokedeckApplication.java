package luisfelipe2.pokedeck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PokedeckApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokedeckApplication.class, args);
	}

}
