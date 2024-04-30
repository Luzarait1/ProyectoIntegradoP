package com.example.ProyectoIntegradoP.Controllers;


import com.example.ProyectoIntegradoP.DTO.ProyectoDto;
import com.example.ProyectoIntegradoP.Models.Proyecto;
import com.example.ProyectoIntegradoP.Service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

//Se hace el requestMapping para los endpoints
@RestController
@RequestMapping("/v1/proyecto")
public class ProyectoController {

    //Inyeccion de dependencias
    private ProyectoService proyectoService;

    @Autowired
    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    //Borrar un proyecto
    @DeleteMapping("/{idProyecto}")
    public void eliminarProyecto(@PathVariable("idProyecto") Long idProyecto) {
        this.proyectoService.eliminarProyecto(idProyecto);
        System.out.println("El proyecto " + idProyecto + " fue eliminado");

    }

    //Crear un proyecto
    @PostMapping("/")
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody ProyectoDto proyectoDto) {
        Proyecto proyectoCreado = proyectoService.crearProyecto(proyectoDto);
        return ResponseEntity.created(URI.create("/v1/proyecto" + proyectoCreado.getIdProyecto())).body(proyectoCreado);

    }

    //Obtener un proyecto
    @GetMapping("/{idProyecto}")
    public ResponseEntity<Proyecto> obtenerProyecto(@PathVariable("idProyecto") Long idProyecto) {
        Proyecto proyecto = proyectoService.obtenerProyecto(idProyecto);
        return ResponseEntity.ok(proyecto);

    }

    //Editar un proyecto
    @PutMapping("/{idProyecto}")
    public ResponseEntity<Proyecto> editarProyecto(@PathVariable("idProyecto") Long idProyecto, @RequestBody Proyecto proyecto) {
        Proyecto proyectoEdit = proyectoService.editarProyecto(idProyecto, proyecto);
        return ResponseEntity.created(URI.create("/v1/projects" + proyectoEdit.getIdProyecto())).body(proyectoEdit);

    }
}