package com.autogestion1.autogestion.servicios;

import com.autogestion1.autogestion.clases.Cursos;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursosServicios {
    private List<Cursos> cursosList;

    // Constructor
    public CursosServicios() {
        cursosList = new ArrayList<>();
        // Aquí podrías inicializar tu lista de cursos si es necesario
    }

    // Método para obtener todos los cursos
    public List<Cursos> getAllCourses() {
        return cursosList;
    }

    // Método para obtener un curso por su ID
    public Cursos getCourseById(String courseId) {
        // Aquí implementarías la lógica para buscar y devolver el curso por su ID
        // Por ahora, solo devolveremos null
        return null;
    }

    // Método para matricular un estudiante en un curso
    public String enrollStudentInCourse(String courseId, String studentId) {
        // Aquí implementarías la lógica para matricular al estudiante en el curso
        // Por ahora, solo devolveremos un mensaje de éxito
        return "Student enrolled in course";
    }

    // Método para desmatricular un estudiante de un curso
    public String unenrollStudentFromCourse(String courseId, String studentId) {
        // Aquí implementarías la lógica para desmatricular al estudiante del curso
        // Por ahora, solo devolveremos un mensaje de éxito
        return "Student unenrolled from course";
    }
}
