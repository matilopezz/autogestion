package com.autogestion1.autogestion.clases;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Estudiantes {
    // Getters y Setters
    private String studentId;
    private String firstName;
    private String lastName;

    // Constructor
    public Estudiantes(String studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
