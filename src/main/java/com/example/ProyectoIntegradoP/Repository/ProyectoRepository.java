package com.example.ProyectoIntegradoP.Repository;

import com.example.ProyectoIntegradoP.Models.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositorio para Proyecto
@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {


}
