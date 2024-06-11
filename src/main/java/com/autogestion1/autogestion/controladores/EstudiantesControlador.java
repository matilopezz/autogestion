package com.autogestion1.autogestion.controladores;

import com.autogestion1.autogestion.clases.Estudiantes;
import com.autogestion1.autogestion.servicios.EstudiantesServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sistema_autogestion") //
public class EstudiantesControlador {

    private final EstudiantesServicios estudiantesServicios;

    @Autowired
    public EstudiantesControlador(EstudiantesServicios estudiantesServicios) {
        this.estudiantesServicios = estudiantesServicios;
    }

    @GetMapping("/estudiantes")
    public ResponseEntity<List<Estudiantes>> getAllStudents() {
        List<Estudiantes> estudiantes = estudiantesServicios.getAllStudents();
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/estudiantes/{studentId}")
    public ResponseEntity<Estudiantes> getStudentById(@PathVariable String studentId) {
        Optional<Estudiantes> estudianteOptional = estudiantesServicios.getStudentById(studentId);
        if (estudianteOptional.isPresent()) {
            return ResponseEntity.ok(estudianteOptional.get()); // Desempaqueta el valor del Optional
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Aquí puedes agregar más endpoints según sea necesario para tu aplicación
}
