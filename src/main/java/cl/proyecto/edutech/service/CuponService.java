package cl.proyecto.edutech.service;
//Roberto Gonzalez

import cl.proyecto.edutech.model.Cupon;
import cl.proyecto.edutech.dto.CuponDTO;
import cl.proyecto.edutech.repository.CuponRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CuponService {

    @Autowired
    private CuponRepository cuponRepo;

    public String crear(Cupon cupon) {
        cuponRepo.save(cupon);
        return "Cupón creado correctamente.";
    }

    public List<CuponDTO> listar() {
        return cuponRepo.findAll()
                        .stream()
                        .map(CuponDTO::new)
                        .collect(Collectors.toList());
    }

    public CuponDTO obtenerPorId(Long id) {
        return cuponRepo.findById(id)
                        .map(CuponDTO::new)
                        .orElse(null);
    }

    public CuponDTO obtenerPorCodigo(String codigo) {
        return cuponRepo.findByCodigo(codigo)
                        .map(CuponDTO::new)
                        .orElse(null);
    }

    public String actualizar(Long id, Cupon cupon) {
        return cuponRepo.findById(id)
            .map(existing -> {
                existing.setCodigo(cupon.getCodigo());
                existing.setDescuento(cupon.getDescuento());
                existing.setValidoHasta(cupon.getValidoHasta());
                cuponRepo.save(existing);
                return "Cupón actualizado correctamente.";
            })
            .orElse("Cupón no encontrado.");
    }

    public String eliminar(Long id) {
        if (cuponRepo.existsById(id)) {
            cuponRepo.deleteById(id);
            return "Cupón eliminado correctamente.";
        }
        return "Cupón no encontrado.";
    }
}
