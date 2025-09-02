package pe.edu.tecsup.lab03.StudentService;

import pe.edu.tecsup.lab03.entities.StudentEntity;
import pe.edu.tecsup.lab03.repositories.StudentRepository;

import java.util.List;

public class StudentService {

    private final StudentRepository repo;

    // Inyección de dependencia (pasamos el repositorio al constructor)
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    // Registrar estudiante (con validación de negocio)
    public StudentEntity register(StudentEntity s) {
        // Lógica de negocio: no registrar si ya existe el ID
        StudentEntity existing = repo.findById(s.getId());
        if (existing != null) {
            throw new IllegalArgumentException("Ya existe un estudiante con ID " + s.getId());
        }
        return repo.save(s);
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
