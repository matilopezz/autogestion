package com.autogestion1.autogestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteControlador {

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    @GetMapping
    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable Long id) {
        return estudianteRepositorio.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Estudiante createEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteRepositorio.save(estudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable Long id, @RequestBody Estudiante estudianteDetails) {
        return estudianteRepositorio.findById(id)
                .map(estudiante -> {
                    estudiante.setNombre(estudianteDetails.getNombre());
                    estudiante.setApellido(estudianteDetails.getApellido());
                    estudiante.setCorreoElectronico(estudianteDetails.getCorreoElectronico());
                    Estudiante updatedEstudiante = estudianteRepositorio.save(estudiante);
                    return ResponseEntity.ok(updatedEstudiante);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Long id) {
        return estudianteRepositorio.findById(id)
                .map(estudiante -> {
                    estudianteRepositorio.delete(estudiante);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
