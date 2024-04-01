package com.example.contenidosMultimedia.domain.repository;

import com.example.contenidosMultimedia.persistence.dto.ContenidoAudioVisualDto;
import com.example.contenidosMultimedia.persistence.entity.ContenidoAudioVisual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContenidoAudioVisualRepo extends JpaRepository<ContenidoAudioVisual,Long> {


    @Query("SELECT ca.id, ca.tipoDeContenido, ca.genero, ca.estadoDeVisualizacion, ca.plataforma, ca.calificacion, ca.comentario FROM  ContenidoAudioVisual ca WHERE ca.tipoDeContenido = ?1  ORDER BY ca.tipoDeContenido")
    public List<Object[]> obtenerPorTipoDeContenido(String tipoDeContenido);


    @Query("SELECT ca.id, ca.tipoDeContenido, ca.genero, ca.estadoDeVisualizacion, ca.plataforma, ca.calificacion, ca.comentario FROM  ContenidoAudioVisual ca WHERE ca.genero = ?1  ORDER BY ca.genero")
    public List<Object[]> obtenerPorGenero(String genero);


    @Query("SELECT ca.id, ca.tipoDeContenido, ca.genero, ca.estadoDeVisualizacion, ca.plataforma, ca.calificacion, ca.comentario FROM  ContenidoAudioVisual ca WHERE ca.estadoDeVisualizacion = ?1  ORDER BY ca.estadoDeVisualizacion")
    public List<Object[]> obtenerPorEstadoDeVisualizacion(String estadoDeVizualizacion);


    @Query("SELECT ca.id, ca.tipoDeContenido, ca.genero, ca.estadoDeVisualizacion, ca.plataforma, ca.calificacion, ca.comentario FROM  ContenidoAudioVisual ca WHERE ca.plataforma = ?1  ORDER BY ca.plataforma")
    public List<Object[]> obtenerPorPlataforma(String plataforma);


    @Query("SELECT ca.id, ca.tipoDeContenido, ca.genero, ca.estadoDeVisualizacion, ca.plataforma, ca.calificacion, ca.comentario FROM  ContenidoAudioVisual ca WHERE ca.calificacion = ?1  ORDER BY ca.calificacion")
    public List<Object[]> obtenerPorCalificacion(String calificacion);





}
