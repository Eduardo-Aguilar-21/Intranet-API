package com.telandash.intranet.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
public class TestController {

    @PreAuthorize("hasAuthority('ROLE_Alumno')")
    @GetMapping("/alumnos")
    public String alumnos(){
        return "Hola alumnos";
    }

    @PreAuthorize("hasAuthority('ROLE_Profesor')")
    @GetMapping("/profesor")
    public String profesor(){
        return "Hola PRofesor";
    }

    @GetMapping("/general")
    public String general(){
        return "Hola general";
    }
}
