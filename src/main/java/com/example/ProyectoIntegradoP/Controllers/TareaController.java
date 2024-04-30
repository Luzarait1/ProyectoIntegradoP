package com.example.ProyectoIntegradoP.Controllers;


import com.example.ProyectoIntegradoP.DTO.TareaDto;
import com.example.ProyectoIntegradoP.Models.Tarea;
import com.example.ProyectoIntegradoP.Service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

//Se hace el requestMapping para los endpoints
@RestController
@RequestMapping("/v1/tarea")
public class TareaController {

    //Inyeccion de dependencias
    private TareaService tareaService;

    @Autowired
    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    //Crear una tarea
    @PostMapping("/proyecto/{idProyecto}")
    public ResponseEntity<Tarea> crearTarea(@PathVariable("idProyecto") Long idProyecto, @RequestBody TareaDto tareaDto) {
        Tarea tareaCreada = tareaService.crearTarea(idProyecto, tareaDto);
        return ResponseEntity.created(URI.create("/v1/tarea" + tareaCreada.getIdTarea())).body(tareaCreada);

    }

    //Borrar una tarea
    @DeleteMapping("/{idTarea}")
    public void eliminarTarea(@PathVariable("idTarea") Long idTarea) {
        this.tareaService.eliminarTarea(idTarea);
        System.out.println("La tarea " + idTarea + " fue eliminada");

    }

    //Obtener una tarea
    @GetMapping("/{idTarea}")
    public ResponseEntity<Tarea> getTask(@PathVariable("idTarea") Long idTarea){
        Tarea tarea = tareaService.obtenerTarea(idTarea);
        return ResponseEntity.ok(tarea);

    }

}
