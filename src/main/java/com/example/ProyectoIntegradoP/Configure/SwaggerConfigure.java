package com.example.ProyectoIntegradoP.Configure;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

//Se usa swagger para la documentacion de la API
@Configuration

@OpenAPIDefinition(info = @Info(title = "API REST de Kanban", version = "1.0.0", description = "El proyecto es una REST API para un sistema " +
        "Kanban basado en la web para gestionar proyectos, organizar tareas y realizar un seguimiento al progreso de las tareas"))

public class SwaggerConfigure {

}