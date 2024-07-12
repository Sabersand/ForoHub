package com.AluraCursos.ForoHub.domain.usuario;

import jakarta.validation.constraints.NotBlank;


public record DatosRegistroUsuario(Long id,
                                   @NotBlank
                                   String username,
                                   @NotBlank
                                   String password) {
}
