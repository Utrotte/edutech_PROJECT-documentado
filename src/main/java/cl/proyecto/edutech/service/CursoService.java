//Victor Espindola
package cl.proyecto.edutech.service;

import cl.proyecto.edutech.model.Curso;
import cl.proyecto.edutech.dto.CursoDTO; 
import cl.proyecto.edutech.model.Instructor; 
import cl.proyecto.edutech.repository.CursoRepository;
import cl.proyecto.edutech.repository.InstructorRepository; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional; 
import java.util.stream.Collectors; 

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository; 

    @Autowired
    private InstructorRepository instructorRepository;

    public String crear(Curso curso) { 
 
        cursoRepository.save(curso);
        return "Curso creado correctamente.";
    }

    public List<Curso> listar() { 
        return cursoRepository.findAll();
    }

    public CursoDTO obtenerPorId(int id) { 
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        if (cursoOptional.isPresent()) {
            return new CursoDTO(cursoOptional.get()); 
        }
        return null; 
    }

    public String actualizar(int id, Curso cursoDetalles) { 
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        if (cursoOptional.isPresent()) {
            Curso cursoExistente = cursoOptional.get();
            cursoExistente.setTitulo(cursoDetalles.getTitulo());
            cursoExistente.setDescripcion(cursoDetalles.getDescripcion());
            cursoExistente.setEstado(cursoDetalles.getEstado());
            cursoExistente.setFechaPublicacion(cursoDetalles.getFechaPublicacion()); 

            if (cursoDetalles.getInstructor() != null && cursoDetalles.getInstructor().getInstructorId() != null) {
                Instructor instructor = instructorRepository.findById(cursoDetalles.getInstructor().getInstructorId())
                    .orElseThrow(() -> new RuntimeException("Instructor no encontrado con ID: " + cursoDetalles.getInstructor().getInstructorId()));
                cursoExistente.setInstructor(instructor);
            } else {
                cursoExistente.setInstructor(null); //  desasignar instructor >.<
            }
            
            cursoRepository.save(cursoExistente);
            return "Curso actualizado correctamente.";
        }
        return "Curso no encontrado.";
    }

    public String eliminar(int id) {
        if (cursoRepository.existsById(id)) {  //cuidado con las dependencias :)
            cursoRepository.deleteById(id);
            return "Curso eliminado correctamente.";
        }
        return "Curso no encontrado.";
    }

    // Método para listar por instructor
    public List<CursoDTO> listarPorInstructor(Long instructorId) {
        return cursoRepository.findByInstructorInstructorId(instructorId)
                .stream()
                .map(CursoDTO::new)
                .collect(Collectors.toList());
    }
}
