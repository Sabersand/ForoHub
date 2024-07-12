package com.AluraCursos.ForoHub.domain.posts;


import jakarta.validation.constraints.NotBlank;


public record DatosRegistroTopico(Long id,
                                  @NotBlank
                                  String titulo,
                                  @NotBlank
                                  String mensaje,
                                  @NotBlank
                                  String autor,
                                  @NotBlank
                                  String curso,
                                  String fechaCreacion,
                                  Boolean estado) {
}
