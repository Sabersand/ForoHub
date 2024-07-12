package com.AluraCursos.ForoHub.domain.posts;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fechaCreacion;
    private Boolean estado;
    private String curso;
    private String usuarioId;


    public Topico(DatosRegistroTopico datosRegistroUsuario){

        this.titulo = datosRegistroUsuario.titulo();
        this.mensaje = datosRegistroUsuario.mensaje();
        this.usuarioId = datosRegistroUsuario.autor();
        this.curso = datosRegistroUsuario.curso();
    }


    public void actualizarTopico(DatosActualizacionTopico datosActualizacionTopico) {
        this.mensaje = datosActualizacionTopico.mensaje();
        this.estado = datosActualizacionTopico.estado();
    }
}
