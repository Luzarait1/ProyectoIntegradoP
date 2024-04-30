package com.example.ProyectoIntegradoP.DTO;


import org.springframework.stereotype.Component;

//Se crea la clase ProyectoDTO para que el usuario no tenga que ingresar todos los datos por teclado
@Component
public class ProyectoDto {
    private String nombre;
    private String descripcion;

    public ProyectoDto() {

    }

    public ProyectoDto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

