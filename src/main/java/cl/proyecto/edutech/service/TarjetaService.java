//francisco Rodriguez
package cl.proyecto.edutech.service;

import cl.proyecto.edutech.model.Tarjeta;
import cl.proyecto.edutech.dto.TarjetaDTO;
import cl.proyecto.edutech.repository.TarjetaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarjetaService {

    @Autowired
    private TarjetaRepository tarjetaRepo;

    public String crear(Tarjeta tarjeta) {
        tarjetaRepo.save(tarjeta);
        return "Tarjeta creada correctamente.";
    }

    public List<TarjetaDTO> listar() {
        return tarjetaRepo.findAll()
                          .stream()
                          .map(TarjetaDTO::new)
                          .collect(Collectors.toList());
    }

    public List<TarjetaDTO> listarPorUsuario(Long usuarioId) {
        return tarjetaRepo.findByUsuarioUsuarioId(usuarioId)
                          .stream()
                          .map(TarjetaDTO::new)
                          .collect(Collectors.toList());
    }

    public String actualizar(Long id, Tarjeta tarjeta) {
        return tarjetaRepo.findById(id)
            .map(existing -> {
                existing.setNumero(tarjeta.getNumero());
                existing.setFechaVencimiento(tarjeta.getFechaVencimiento());
                existing.setFormaDePago(tarjeta.getFormaDePago());
                tarjetaRepo.save(existing);
                return "Tarjeta actualizada correctamente.";
            })
            .orElse("Tarjeta no encontrada.");
    }

    public String eliminar(Long id) {
        if (tarjetaRepo.existsById(id)) {
            tarjetaRepo.deleteById(id);
            return "Tarjeta eliminada correctamente.";
        }
        return "Tarjeta no encontrada.";
    }
}
