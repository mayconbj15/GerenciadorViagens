package gerenciador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories("entidades.Viagem")
@ComponentScan(basePackages = { "entidades.Viagem" })
@EntityScan("entidades.Viagem")
public class GerenciadorViagensMonstanhaApplication {
    public static void main(String[] args){
        SpringApplication.run(GerenciadorViagensMonstanhaApplication.class, args);
    }
}
