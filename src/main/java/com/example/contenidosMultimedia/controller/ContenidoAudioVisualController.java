package com.example.contenidosMultimedia.controller;


import com.example.contenidosMultimedia.domain.service.ContenidoAudioVisualService;
import com.example.contenidosMultimedia.persistence.dto.ContenidoAudioVisualDto;
import com.example.contenidosMultimedia.persistence.entity.ContenidoAudioVisual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contenido")

public class ContenidoAudioVisualController {

    @Autowired
    private ContenidoAudioVisualService contenidoAudioVisualService;


    @GetMapping("/todos")
    public ResponseEntity<?> obtenerTodosLosContenidos() {

        List<ContenidoAudioVisualDto> contenidosDto = contenidoAudioVisualService.obtenerTodosLosContenidos();

        if (contenidosDto.isEmpty()) {

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(contenidosDto);

    }

    @GetMapping("/todos/porTipoDeContenido"  )
    public ResponseEntity<?> obtenerPorTipoDeContenido(@RequestParam  String tipoDeContenido){

        List<ContenidoAudioVisualDto> contenidosDto = contenidoAudioVisualService.obtenerPorTipoDeContenido(tipoDeContenido);

        if (contenidosDto.isEmpty()) {

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(contenidosDto);

    }

    @GetMapping ("todos/porGenero")
    public ResponseEntity<?>  obtenerPorGenero(@RequestParam  String genero){

        List<ContenidoAudioVisualDto> contenidosDto = contenidoAudioVisualService.obtenerPorGenero(genero);

        if (contenidosDto.isEmpty()) {

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(contenidosDto);

    }


    @GetMapping ("todos/porGenero")
    public ResponseEntity<?> obtenerPorEstadoDeVisualizacion(@RequestParam  String estadoDeVizualizacion){

        List<ContenidoAudioVisualDto> contenidosDto = contenidoAudioVisualService.obtenerPorEstadoDeVisualizacion(estadoDeVizualizacion);

        if (contenidosDto.isEmpty()) {

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(contenidosDto);
    }


    @GetMapping ("todos/porGenero")
    public ResponseEntity<?> obtenerPorPlataforma(@RequestParam  String plataforma){

        List<ContenidoAudioVisualDto> contenidosDto = contenidoAudioVisualService.obtenerPorPlataforma(plataforma);

        if (contenidosDto.isEmpty()) {

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(contenidosDto);


    }


    @GetMapping ("todos/porGenero")
    public ResponseEntity<?> obtenerPorCalificacion( @RequestParam  String calificacion){



        List<ContenidoAudioVisualDto> contenidosDto = contenidoAudioVisualService.obtenerPorCalificacion(calificacion);

        if (contenidosDto.isEmpty()) {

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(contenidosDto);

    }


    @PostMapping( "guardarContendio")
    public  ResponseEntity<?> guardarContenido(@RequestParam ContenidoAudioVisual contenidoAudioVisual){

        ContenidoAudioVisualDto contenidoAudioVisualDto = contenidoAudioVisualService.guardarContenido(contenidoAudioVisual);


        return ResponseEntity.ok().body(contenidoAudioVisualDto);


    }

    @PutMapping ("actualizarContenido/{id}")
    public ResponseEntity<?> actualizarContenido(@PathVariable Long id , @RequestParam ContenidoAudioVisual contenidoAudioVisual){

        ContenidoAudioVisualDto contenidoAudioVisualDto = contenidoAudioVisualService.actualizarContenido(id, contenidoAudioVisual);


        return ResponseEntity.ok().body(contenidoAudioVisualDto);

    }


    @DeleteMapping("borrarContenido/{id}")
    public ResponseEntity<?>  deleteContenido(@PathVariable Long id ){
            contenidoAudioVisualService.borrarContenido(id);
            return ResponseEntity.ok().build();
    }


}
