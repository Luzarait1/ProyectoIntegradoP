package com.example.ProyectoIntegradoP.Models;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Se crea la clase Proyecto con sus respectivos atributos y metodos (tambien se usa JPA)
@Entity
@Table(name = "proyecto")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProyecto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "status")
    private String status;

    @Column(name = "fecha_creacion")
    private LocalDateTime createdDate;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime lastUpdatedDate;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Tarea> listaTareas = new ArrayList<>();

    public Proyecto(Long idProyecto, String nombre, String descripcion, LocalDateTime createdDate, LocalDateTime lastUpdatedDate, List<Tarea> listaTareas) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.listaTareas = listaTareas;
    }

    public Proyecto() {

    }

    public Proyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public List<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /*
    public void setProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    } */

}