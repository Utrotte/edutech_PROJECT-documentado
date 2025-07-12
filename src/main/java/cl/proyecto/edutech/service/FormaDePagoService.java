// victor espindola
package cl.proyecto.edutech.service;

import cl.proyecto.edutech.model.FormaDePago;
import cl.proyecto.edutech.dto.FormaDePagoDTO;
import cl.proyecto.edutech.repository.FormaDePagoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormaDePagoService {

    @Autowired
    private FormaDePagoRepository formaRepo;

    public String crear(FormaDePago formaDePago) {
        formaRepo.save(formaDePago);
        return "Forma de pago creada correctamente.";
    }

    public List<FormaDePagoDTO> listar() {
        return formaRepo.findAll()
                       .stream()
                       .map(FormaDePagoDTO::new)
                       .collect(Collectors.toList());
    }

    public FormaDePagoDTO obtenerPorId(Integer id) {
        return formaRepo.findById(id)
                        .map(FormaDePagoDTO::new)
                        .orElse(null);
    }

    public FormaDePagoDTO obtenerPorNombre(String nombre) {
        return formaRepo.findByNombre(nombre)
                        .map(FormaDePagoDTO::new)
                        .orElse(null);
    }

    public String actualizar(Integer id, FormaDePago formaDePago) {
        return formaRepo.findById(id)
            .map(existing -> {
                existing.setNombre(formaDePago.getNombre());
                existing.setDescripcion(formaDePago.getDescripcion());
                formaRepo.save(existing);
                return "Forma de pago actualizada correctamente.";
            })
            .orElse("Forma de pago no encontrada.");
    }

    public String eliminar(Integer id) {
        if (formaRepo.existsById(id)) {
            formaRepo.deleteById(id);
            return "Forma de pago eliminada correctamente.";
        }
        return "Forma de pago no encontrada.";
    }
}
