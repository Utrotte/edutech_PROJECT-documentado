//Roberto Gonzalez

package cl.proyecto.edutech.service;

import cl.proyecto.edutech.model.Instructor;
import cl.proyecto.edutech.dto.InstructorDTO;
import cl.proyecto.edutech.repository.InstructorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepo;

    public String crear(Instructor instructor) {
        instructorRepo.save(instructor);
        return "Instructor creado correctamente.";
    }

    public List<InstructorDTO> listar() {
        return instructorRepo.findAll()
                             .stream()
                             .map(InstructorDTO::new)
                             .collect(Collectors.toList());
    }

    public InstructorDTO obtenerPorId(Long id) {
        return instructorRepo.findById(id)
                             .map(InstructorDTO::new)
                             .orElse(null);
    }

    public InstructorDTO obtenerPorUsuario(Long usuarioId) {
        return instructorRepo.findByUsuarioUsuarioId(usuarioId)
                             .map(InstructorDTO::new)
                             .orElse(null);
    }

    public String actualizar(Long id, Instructor instructor) {
        return instructorRepo.findById(id)
            .map(existing -> {
                existing.setEspecialidad(instructor.getEspecialidad());
                instructorRepo.save(existing);
                return "Instructor actualizado correctamente.";
            })
            .orElse("Instructor no encontrado.");
    }

    public String eliminar(Long id) {
        if (instructorRepo.existsById(id)) {
            instructorRepo.deleteById(id);
            return "Instructor eliminado correctamente.";
        }
        return "Instructor no encontrado.";
    }
}
