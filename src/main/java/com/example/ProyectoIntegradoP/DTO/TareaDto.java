package com.example.ProyectoIntegradoP.DTO;



import org.springframework.stereotype.Component;

import java.time.LocalDate;

//Se crea la clase TareaDTO para que el usuario no tenga que ingresar todos los datos por teclado
@Component
public class TareaDto {

    private String nombre;
    private String descripcion;
    private String tipo;
    private LocalDate startDate;
    private LocalDate dueDate;

    public TareaDto() {

    }

    public TareaDto(String nombre, String descripcion, String tipo, LocalDate startDate, LocalDate dueDate) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.startDate = startDate;
        this.dueDate = dueDate;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
