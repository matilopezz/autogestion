package com.autogestion1.autogestion.clases;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cursos {

    // Getters y Setters
    private String courseId;
    private String courseName;
    private String description;

    // Constructor
    public Cursos(String courseId, String courseName, String description) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
    }

}
