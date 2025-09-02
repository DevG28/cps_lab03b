package pe.edu.tecsup.lab03.services;

import pe.edu.tecsup.lab03.entities.StudentEntity;
import pe.edu.tecsup.lab03.repositories.StudentRepository;

import java.util.List;

public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    // Registrar estudiante (si no existe el ID)
    public void register(StudentEntity s) {
        if (s.getId() != null) {
            StudentEntity existing = repo.findById(s.getId());
            if (existing != null) {
                throw new IllegalArgumentException("Ya existe un estudiante con ID " + s.getId());
            }
        }
        repo.save(s);
    }

    // Obtener estudiante por ID
    public StudentEntity get(Long id) {
        return repo.findById(id);
    }

    // Listar todos los estudiantes
    public List<StudentEntity> list() {
        return repo.findAll();
    }
}
