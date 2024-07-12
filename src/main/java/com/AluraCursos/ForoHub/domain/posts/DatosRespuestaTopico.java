package com.AluraCursos.ForoHub.domain.posts;


import java.time.LocalDate;
import java.time.LocalDateTime;

public record DatosRespuestaTopico(Long id,
                                   String autor,
                                   String mensaje,
                                   String fecha_creacion,
                                   Boolean estado) {
}
