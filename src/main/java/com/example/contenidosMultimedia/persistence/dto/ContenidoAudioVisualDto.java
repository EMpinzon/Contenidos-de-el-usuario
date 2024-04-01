package com.example.contenidosMultimedia.persistence.dto;


import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class ContenidoAudioVisualDto {


    private Long id;

    private String tipoDeContenido;

    private String genero;

    private String estadoDeVisualizacion;

    private String plataforma;

    private String calificacion;

    private String comentario;
}
