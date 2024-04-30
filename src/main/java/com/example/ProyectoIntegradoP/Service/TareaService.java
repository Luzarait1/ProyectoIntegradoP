package com.example.ProyectoIntegradoP.Service;


import com.example.ProyectoIntegradoP.DTO.TareaDto;
import com.example.ProyectoIntegradoP.Exceptions.ApiRequestException;
import com.example.ProyectoIntegradoP.Models.Proyecto;
import com.example.ProyectoIntegradoP.Models.Tarea;
import com.example.ProyectoIntegradoP.Models.TaskStatus;
import com.example.ProyectoIntegradoP.Repository.ProyectoRepository;
import com.example.ProyectoIntegradoP.Repository.TareaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TareaService {

    private ProyectoRepository proyectoRepository;
    private TareaRepository tareaRepository;

    public TareaService(ProyectoRepository proyectoRepository, TareaRepository tareaRepository) {
        this.proyectoRepository = proyectoRepository;
        this.tareaRepository = tareaRepository;
    }


    //Se crea una tarea por medio del DTO y su proyecto padre
    public Tarea crearTarea(Long idProyecto, TareaDto tareaDto) {

        Optional<Proyecto> proyectoPadre = proyectoRepository.findById(idProyecto);
        if (!proyectoPadre.isPresent()) {
            System.out.println("El proyecto no existe");
        }

        Tarea nuevaTarea = new Tarea();
        nuevaTarea.setNombre(tareaDto.getNombre());
        nuevaTarea.setDescripcion(tareaDto.getDescripcion());
        nuevaTarea.setTareaStatus(TaskStatus.TODO);
        nuevaTarea.setTipo(tareaDto.getTipo());
        nuevaTarea.setStartDate(tareaDto.getStartDate());
        nuevaTarea.setDueDate(tareaDto.getDueDate());
        nuevaTarea.setCreatedDate(LocalDate.now());
        nuevaTarea.setLastUpdatedDate(LocalDateTime.now());
        nuevaTarea.setProyecto(proyectoPadre.get());

        Tarea tareaGuardada = tareaRepository.save(nuevaTarea);
        return tareaGuardada;
    }

    //Eliminar una tarea
    public void eliminarTarea(Long idTarea) {
        Optional <Tarea> tareaEncontrada = tareaRepository.findById(idTarea);

        //Si existe el proyecto, se elimina por el idTarea
        if(tareaEncontrada.isPresent()){
            tareaRepository.deleteById(idTarea);

            //Si no existe, se lanza una excepcion
        } else {
            System.out.println("La tarea no existe");
        }
    }

    /*
    public Tarea obtenerTarea(Long idTarea) {
        Optional <Tarea> tareaEncontrada = tareaRepository.findById(idTarea);
        if(tareaEncontrada.isPresent()){
            Tarea tarea = tareaEncontrada.get();

            Long idProyecto = tarea.getIdProyecto();
            tarea.setProyecto(idProyecto);
            return tarea;
        } else {
            throw new ApiRequestException("La tarea no fue encontrada");
        }
    }
*/
    //Obtener una tarea
    public Tarea obtenerTarea(Long idTarea) {
        Optional <Tarea> tareaExiste = tareaRepository.findById(idTarea);

        //Si existe la tarea, se muestra por medio del get
        if(tareaExiste.isPresent()){
            return tareaExiste.get();

            //Si no existe, se lanza una excepcion
        } else {
            throw new ApiRequestException("La tarea no existe");
        }
    }

}