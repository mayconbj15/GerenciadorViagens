package gerenciador.repositories;

import entidades.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {
    Viagem findByLocalDeDestino(String localDeDestino);
}
