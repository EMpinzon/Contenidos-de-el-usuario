package com.example.contenidosMultimedia.domain.service.impl;


import com.example.contenidosMultimedia.domain.repository.ContenidoAudioVisualRepo;
import com.example.contenidosMultimedia.domain.service.ContenidoAudioVisualService;
import com.example.contenidosMultimedia.persistence.dto.ContenidoAudioVisualDto;
import com.example.contenidosMultimedia.persistence.entity.ContenidoAudioVisual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service


public class ContenidoAudioVisualServiceImpl implements ContenidoAudioVisualService {

    @Autowired
    private ContenidoAudioVisualRepo contenidoAudioVisualRepo;


    @Override
    public List<ContenidoAudioVisualDto>  obtenerTodosLosContenidos() {

        List<ContenidoAudioVisual> contenidos =  contenidoAudioVisualRepo.findAll();

        List<ContenidoAudioVisualDto> contenidosDto = new ArrayList<>();

        contenidos.stream().forEach( x ->{
            contenidosDto.add(ContenidoAudioVisualDto.builder().id(x.getId()).tipoDeContenido(x.getTipoDeContenido()).genero(x.getGenero())
                    .estadoDeVisualizacion(x.getEstadoDeVisualizacion())
                    .plataforma(x.getPlataforma()).calificacion(x.getCalificacion()).comentario(x.getComentario()).build());

        }  );


        return contenidosDto;


    }

    @Override
    public List<ContenidoAudioVisualDto> obtenerPorTipoDeContenido(String tipoDeContenido) {
        List<Object[]>  contenidos   = contenidoAudioVisualRepo.obtenerPorTipoDeContenido(tipoDeContenido);
        List<ContenidoAudioVisualDto> contenidoAudioVisualDtos = new ArrayList<>();

        contenidos.stream().forEach( x ->{

            contenidoAudioVisualDtos.add(ContenidoAudioVisualDto.builder().id( (Long) x[0]).tipoDeContenido( (String) x[1] )
                            .genero( (String) x[2]  ).estadoDeVisualizacion( (String) x[3] ).plataforma( (String) x[4])
                            .calificacion((String) x[5] ).comentario( (String) x[6]).build()  );

        } );

        return contenidoAudioVisualDtos;


    }

    @Override
    public List<ContenidoAudioVisualDto> obtenerPorGenero(String genero) {
        List<Object[]>  contenidos   = contenidoAudioVisualRepo.obtenerPorGenero(genero);
        List<ContenidoAudioVisualDto> contenidoAudioVisualDtos = new ArrayList<>();

        contenidos.stream().forEach( x ->{

            contenidoAudioVisualDtos.add(ContenidoAudioVisualDto.builder().id( (Long) x[0]).tipoDeContenido( (String) x[1] )
                    .genero( (String) x[2]  ).estadoDeVisualizacion( (String) x[3] ).plataforma( (String) x[4])
                    .calificacion((String) x[5] ).comentario( (String) x[6]).build()  );

        } );

        return contenidoAudioVisualDtos;
    }

    @Override
    public List<ContenidoAudioVisualDto> obtenerPorEstadoDeVisualizacion(String estadoDeVizualizacion) {
        List<Object[]>  contenidos   = contenidoAudioVisualRepo.obtenerPorEstadoDeVisualizacion(estadoDeVizualizacion);
        List<ContenidoAudioVisualDto> contenidoAudioVisualDtos = new ArrayList<>();
        contenidos.stream().forEach( x ->{

            contenidoAudioVisualDtos.add(ContenidoAudioVisualDto.builder().id( (Long) x[0]).tipoDeContenido( (String) x[1] )
                    .genero( (String) x[2]  ).estadoDeVisualizacion( (String) x[3] ).plataforma( (String) x[4])
                    .calificacion((String) x[5] ).comentario( (String) x[6]).build()  );

        } );

        return contenidoAudioVisualDtos;
    }

    @Override
    public List<ContenidoAudioVisualDto> obtenerPorPlataforma(String plataforma) {
        List<Object[]>  contenidos   = contenidoAudioVisualRepo.obtenerPorPlataforma(plataforma);
        List<ContenidoAudioVisualDto> contenidoAudioVisualDtos = new ArrayList<>();
        contenidos.stream().forEach( x ->{

            contenidoAudioVisualDtos.add(ContenidoAudioVisualDto.builder().id( (Long) x[0]).tipoDeContenido( (String) x[1] )
                    .genero( (String) x[2]  ).estadoDeVisualizacion( (String) x[3] ).plataforma( (String) x[4])
                    .calificacion((String) x[5] ).comentario( (String) x[6]).build()  );

        } );

        return contenidoAudioVisualDtos;
    }

    @Override
    public List<ContenidoAudioVisualDto> obtenerPorCalificacion(String calificacion) {

        List<Object[]>  contenidos   = contenidoAudioVisualRepo.obtenerPorCalificacion(calificacion);
        List<ContenidoAudioVisualDto> contenidoAudioVisualDtos = new ArrayList<>();

        contenidos.stream().forEach( x ->{

            contenidoAudioVisualDtos.add(ContenidoAudioVisualDto.builder().id( (Long) x[0]).tipoDeContenido( (String) x[1] )
                    .genero( (String) x[2]  ).estadoDeVisualizacion( (String) x[3] ).plataforma( (String) x[4])
                    .calificacion((String) x[5] ).comentario( (String) x[6]).build()  );

        } );

        return contenidoAudioVisualDtos;

    }

    @Override
    public ContenidoAudioVisualDto guardarContenido(ContenidoAudioVisual contenidoAudioVisual) {

        contenidoAudioVisualRepo.save(contenidoAudioVisual);

        return ContenidoAudioVisualDto.builder().id(contenidoAudioVisual.getId()).tipoDeContenido(contenidoAudioVisual.getTipoDeContenido())
                .genero(contenidoAudioVisual.getGenero())
                .estadoDeVisualizacion(contenidoAudioVisual.getEstadoDeVisualizacion())
                .plataforma(contenidoAudioVisual.getPlataforma()).calificacion(contenidoAudioVisual.getCalificacion())
                .comentario(contenidoAudioVisual.getComentario()).build();


    }

    @Override
    public ContenidoAudioVisualDto actualizarContenido(Long id, ContenidoAudioVisual contenidoAudioVisual) {


        ContenidoAudioVisual contenido = contenidoAudioVisualRepo.findById(id).map( x -> {
            x.setTipoDeContenido(contenidoAudioVisual.getTipoDeContenido());
            x.setGenero(contenidoAudioVisual.getGenero());
            x.setEstadoDeVisualizacion(contenidoAudioVisual.getEstadoDeVisualizacion());
            x.setPlataforma(contenidoAudioVisual.getPlataforma());
            x.setCalificacion(contenidoAudioVisual.getCalificacion());
            x.setComentario(contenidoAudioVisual.getComentario());

            return contenidoAudioVisualRepo.save(x);

        }).orElseGet(()->{

            contenidoAudioVisual.setId(id);
            return contenidoAudioVisualRepo.save(contenidoAudioVisual);
        }

        );

        return ContenidoAudioVisualDto.builder().id(contenido.getId()).tipoDeContenido(contenido.getTipoDeContenido())
                .genero(contenido.getGenero())
                .estadoDeVisualizacion(contenido.getEstadoDeVisualizacion())
                .plataforma(contenido.getPlataforma()).calificacion(contenido.getCalificacion())
                .comentario(contenido.getComentario()).build();
    }

    @Override
    public void borrarContenido(Long id) {

        contenidoAudioVisualRepo.deleteById(id);  ;

    }


}
