package pe.edu.tecsup.lab03.repositories;

import pe.edu.tecsup.lab03.entities.StudentEntity;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private List<StudentEntity> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
    }

    public void save(StudentEntity student) {
        students.add(student);
    }

    public List<StudentEntity> findAll() {
        return students;
    }

    public StudentEntity findById(Long id) {
        for (StudentEntity student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public boolean deleteById(Long id) {
        return students.removeIf(student -> student.getId().equals(id));
    }
}
