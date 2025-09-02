package pe.edu.tecsup.lab03.repositories;

import pe.edu.tecsup.lab03.entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

public class gitStudentRepository {

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

    public StudentEntity findById(String id) {
        for (StudentEntity student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
}