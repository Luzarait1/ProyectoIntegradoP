package com.example.ProyectoIntegradoP.Repository;

import com.example.ProyectoIntegradoP.Models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositorio para Tarea
@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {

}
