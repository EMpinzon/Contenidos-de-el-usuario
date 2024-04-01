package com.example.contenidosMultimedia.domain.service;

import com.example.contenidosMultimedia.domain.repository.ContenidoAudioVisualRepo;
import com.example.contenidosMultimedia.persistence.dto.ContenidoAudioVisualDto;
import com.example.contenidosMultimedia.persistence.entity.ContenidoAudioVisual;

import java.util.List;

public interface ContenidoAudioVisualService {



    public List<ContenidoAudioVisualDto> obtenerTodosLosContenidos();



    public List<ContenidoAudioVisualDto> obtenerPorTipoDeContenido(String tipoDeContenido);


    public List<ContenidoAudioVisualDto> obtenerPorGenero (String genero);


    public List<ContenidoAudioVisualDto> obtenerPorEstadoDeVisualizacion (String estadoDeVizualizacion);


    public List<ContenidoAudioVisualDto> obtenerPorPlataforma (String plataforma);

    public List<ContenidoAudioVisualDto> obtenerPorCalificacion (String calificacion);

    public  ContenidoAudioVisualDto guardarContenido( ContenidoAudioVisual contenidoAudioVisual );

    public ContenidoAudioVisualDto actualizarContenido( Long id, ContenidoAudioVisual contenidoAudioVisual ) ;

    public void borrarContenido(Long id);

}
