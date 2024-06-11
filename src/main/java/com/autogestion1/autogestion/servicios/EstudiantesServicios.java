package com.autogestion1.autogestion.servicios;

import com.autogestion1.autogestion.clases.Estudiantes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstudiantesServicios {

    private List<Estudiantes> estudiantesList;

    public EstudiantesServicios() {
        this.estudiantesList = new ArrayList<>();
        // Aquí podrías inicializar tu lista de estudiantes si es necesario
    }

    public List<Estudiantes> getAllStudents() {
        return estudiantesList;
    }

    public Optional<Estudiantes> getStudentById(String studentId) {
        return estudiantesList.stream()
                .filter(estudiante -> estudiante.getStudentId().equals(studentId))
                .findFirst();
    }

    public void addStudent(Estudiantes estudiante) {
        estudiantesList.add(estudiante);
    }

    public boolean updateStudent(String studentId, Estudiantes updatedStudent) {
        Optional<Estudiantes> existingStudent = getStudentById(studentId);
        if (existingStudent.isPresent()) {
            int index = estudiantesList.indexOf(existingStudent.get());
            estudiantesList.set(index, updatedStudent);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteStudent(String studentId) {
        Optional<Estudiantes> existingStudent = getStudentById(studentId);
        if (existingStudent.isPresent()) {
            estudiantesList.remove(existingStudent.get());
            return true;
        } else {
            return false;
        }
    }
}
