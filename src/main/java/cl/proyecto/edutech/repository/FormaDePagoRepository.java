package cl.proyecto.edutech.repository;// victor espindola

import cl.proyecto.edutech.model.FormaDePago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FormaDePagoRepository extends JpaRepository<FormaDePago, Integer> {
    Optional<FormaDePago> findByNombre(String nombre);
}