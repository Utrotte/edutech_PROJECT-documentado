//VICTOR ESPINDOLA
package cl.proyecto.edutech.service;

import cl.proyecto.edutech.model.Resena;
import cl.proyecto.edutech.dto.ResenaDTO;
import cl.proyecto.edutech.repository.ResenaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResenaService {

    @Autowired
    private ResenaRepository resenaRepo;

    public String crear(Resena resena) {
        resenaRepo.save(resena);
        return "Reseña creada correctamente.";
    }

    public List<ResenaDTO> listar() {
        return resenaRepo.findAll()
                         .stream()
                         .map(ResenaDTO::new)
                         .collect(Collectors.toList());
    }

    public ResenaDTO obtenerPorId(int id) {
        return resenaRepo.findById(id)
                         .map(ResenaDTO::new)
                         .orElse(null);
    }

    public List<ResenaDTO> listarPorCurso(int cursoId) {
        return resenaRepo.findByCurso_cursoId(cursoId)
                         .stream()
                         .map(ResenaDTO::new)
                         .collect(Collectors.toList());
    }

    public List<ResenaDTO> listarPorUsuario(Long usuarioId) {
        return resenaRepo.findByUsuarioUsuarioId(usuarioId)
                         .stream()
                         .map(ResenaDTO::new)
                         .collect(Collectors.toList());
    }

    public String actualizar(int id, Resena resena) {
        return resenaRepo.findById(id)
            .map(existing -> {
                existing.setUsuario(resena.getUsuario());
                existing.setCurso(resena.getCurso());
                existing.setCalificacion(resena.getCalificacion());
                existing.setComentario(resena.getComentario());
                existing.setFecha_resena(resena.getFecha_resena());
                resenaRepo.save(existing);
                return "Reseña actualizada correctamente.";
            })
            .orElse("Reseña no encontrada.");
    }

    public String eliminar(int id) {
        if (resenaRepo.existsById(id)) {
            resenaRepo.deleteById(id);
            return "Reseña eliminada correctamente.";
        }
        return "Reseña no encontrada.";
    }
}
