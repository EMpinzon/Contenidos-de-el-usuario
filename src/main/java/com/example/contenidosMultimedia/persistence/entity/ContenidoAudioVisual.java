package com.example.contenidosMultimedia.persistence.entity;


import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="contenido_audio_visual")
public class ContenidoAudioVisual {

    @Id
    @Column(name="id_contenido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name="tipo_contenido")
    private String tipoDeContenido;


    @Column(name="genero")
    private String genero;


    @Column(name="estado_de_visualizacion")
    private String estadoDeVisualizacion;



    @Column(name="plataforma")
    private String plataforma;


    @Column(name="calificacion")
    private String calificacion;


    @Column(name="comentario")
    private String comentario;


}
