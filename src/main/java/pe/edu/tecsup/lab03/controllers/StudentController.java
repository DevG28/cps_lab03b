package pe.edu.tecsup.lab03.controllers;

import pe.edu.tecsup.lab03.entities.StudentEntity;
import pe.edu.tecsup.lab03.services.StudentService;

import java.util.List;

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public void registrarEstudiante(StudentEntity student) {
        studentService.register(student);
        System.out.println("Estudiante registrado: " + student.getNombre());
    }

    public void listarEstudiantes() {
        List<StudentEntity> estudiantes = studentService.list();
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            System.out.println("Lista de estudiantes:");
            for (StudentEntity e : estudiantes) {
                System.out.println(e.getId() + " - " + e.getNombre() + " " + e.getApellido() + " (" + e.getEmail() + ")");
            }
        }
    }

    public void obtenerEstudiante(Long id) {
        StudentEntity estudiante = studentService.get(id);
        if (estudiante != null) {
            System.out.println("Estudiante encontrado: " + estudiante.getNombre() + " " + estudiante.getApellido());
        } else {
            System.out.println("No existe un estudiante con ID " + id);
        }
    }
}
