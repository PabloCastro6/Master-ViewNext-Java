package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Ciudad;
import com.curso.service.CiudadService;

@RestController
@RequestMapping("/api/cities")
public class CiudadController {
    @Autowired
    private CiudadService cityService;

    @GetMapping
    public List<Ciudad> getAllCities() {
        return cityService.getAllCities();
    }

    @PostMapping
    public Ciudad createCity(@RequestBody Ciudad city) {
        return cityService.createCity(city);
    }
}

