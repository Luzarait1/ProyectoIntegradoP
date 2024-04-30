package com.example.ProyectoIntegradoP.Service;


import com.example.ProyectoIntegradoP.DTO.ProyectoDto;
import com.example.ProyectoIntegradoP.Exceptions.ApiRequestException;
import com.example.ProyectoIntegradoP.Models.ProjectStatus;
import com.example.ProyectoIntegradoP.Models.Proyecto;
import com.example.ProyectoIntegradoP.Repository.ProyectoRepository;
import com.example.ProyectoIntegradoP.Repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProyectoService {

    //Se inyectan las dependencias de proyecto repository y tarea repository por medio del constructor
    private ProyectoRepository proyectoRepository;
    private TareaRepository tareaRepository;

    @Autowired
    public ProyectoService(ProyectoRepository proyectoRepository, TareaRepository tareaRepository) {
        this.proyectoRepository = proyectoRepository;
        this.tareaRepository = tareaRepository;
    }

    //Crear un proyecto por medio del DTO
    public Proyecto crearProyecto(ProyectoDto proyectoDto) {

        Proyecto nuevoProyecto = new Proyecto();

        //Crear la informacion necesaria del proyecto
        nuevoProyecto.setNombre(proyectoDto.getNombre());
        nuevoProyecto.setDescripcion(proyectoDto.getDescripcion());
        nuevoProyecto.setStatus(ProjectStatus.ACTIVE.toString());
        nuevoProyecto.setCreatedDate(LocalDateTime.now());
        nuevoProyecto.setLastUpdatedDate(LocalDateTime.now());

        Proyecto proyectoGuardado = proyectoRepository.save(nuevoProyecto);
        return proyectoGuardado;
    }

    //Editar un proyecto
    public Proyecto editarProyecto(Long idProyecto, Proyecto proyecto) {
        Optional<Proyecto> proyectoExiste = proyectoRepository.findById(idProyecto);

        //Si existe el proyecto, se debera guardar la nueva informacion presentada
        if(proyectoExiste.isPresent()) {
            proyectoRepository.save(proyecto);
            System.out.println("El proyecto con id " + idProyecto + " se edito correctamente");
            return proyecto;

            //Si no existe el proyecto, se lanza una excepcion
        } else {
            throw new ApiRequestException("El proyecto con id " + idProyecto + " no se logro editar");
        }
    }

    //Eliminar un proyecto
    public void eliminarProyecto(Long idProyecto) {
        Optional <Proyecto> proyectoExiste = proyectoRepository.findById(idProyecto);

        //Si existe el proyecto, se debera borrarlo y se muestra el mensaje de confirmacion
        if(proyectoExiste.isPresent()){
            proyectoRepository.deleteById(idProyecto);
            System.out.println("El proyecto se elimino correctamente");

            //Si no existe el proyecto, se lanza una excepcion
        } else {
            throw new ApiRequestException("El proyecto con id " + idProyecto + " no se puede borrar o no existe");
        }
    }

    //Obtener un proyecto
    public Proyecto obtenerProyecto(Long idProyecto) {
        Optional<Proyecto> proyectoExiste = proyectoRepository.findById(idProyecto);

        //Si existe el proyecto, se obtiene con el get
        if (proyectoExiste.isPresent()) {
            return proyectoExiste.get();

            //Si no existe el proyecto, se lanza una excepcion
        } else {
            throw new ApiRequestException("El proyecto con id " + idProyecto + " no fue encontrado");
        }
    }
}