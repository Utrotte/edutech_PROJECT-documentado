//Roberto Gonzalez

package cl.proyecto.edutech.service;

import cl.proyecto.edutech.model.MensajeForo;
import cl.proyecto.edutech.dto.MensajeForoDTO;
import cl.proyecto.edutech.repository.MensajeForoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MensajeForoService {

    @Autowired
    private MensajeForoRepository mfRepo;

    public String crear(MensajeForo mf) {
        mfRepo.save(mf);
        return "Mensaje de foro creado.";
    }

    public List<MensajeForoDTO> listar() {
        return mfRepo.findAll()
                     .stream()
                     .map(MensajeForoDTO::new)
                     .collect(Collectors.toList());
    }

    public List<MensajeForoDTO> listarPorCurso(int cursoId) {
        return mfRepo.findByCurso_cursoIdOrderByFechaMensajeDesc(cursoId)
                     .stream()
                     .map(MensajeForoDTO::new)
                     .collect(Collectors.toList());
    }

    public String eliminar(Long id) {
        mfRepo.deleteById(id);
        return "Mensaje de foro eliminado.";
    }
}
