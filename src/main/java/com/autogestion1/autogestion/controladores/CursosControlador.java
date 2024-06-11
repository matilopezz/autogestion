package com.autogestion1.autogestion.controladores;

import com.autogestion1.autogestion.clases.Cursos;
import com.autogestion1.autogestion.servicios.CursosServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CursosControlador {

    @Autowired
    private CursosServicios cursosServicios;

    // Constructor
    public CursosControlador(CursosServicios cursosServicios) {
        this.cursosServicios = cursosServicios;
    }

    // Endpoint para obtener todos los cursos
    @GetMapping("/cursos")
    public ResponseEntity<List<Cursos>> getAllCourses() {
        List<Cursos> cursos = cursosServicios.getAllCourses();
        return ResponseEntity.ok(cursos);
    }

    // Endpoint para obtener un curso por su ID
    @GetMapping("/cursos/{courseId}")
    public ResponseEntity<Cursos> getCourseById(@PathVariable String courseId) {
        Cursos curso = cursosServicios.getCourseById(courseId);
        if (curso != null) {
            return ResponseEntity.ok(curso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para matricular un estudiante en un curso
    @PostMapping("/cursos/{courseId}/enroll/{studentId}")
    public ResponseEntity<String> enrollStudentInCourse(@PathVariable String courseId, @PathVariable String studentId) {
        String message = cursosServicios.enrollStudentInCourse(courseId, studentId);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    // Endpoint para desmatricular un estudiante de un curso
    @DeleteMapping("/cursos/{courseId}/unenroll/{studentId}")
    public ResponseEntity<String> unenrollStudentFromCourse(@PathVariable String courseId, @PathVariable String studentId) {
        String message = cursosServicios.unenrollStudentFromCourse(courseId, studentId);
        return ResponseEntity.ok(message);
    }

}
