package com.AluraCursos.ForoHub.controller;

import com.AluraCursos.ForoHub.infra.security.DatosJWToken;
import com.AluraCursos.ForoHub.infra.security.JWTService;
import com.AluraCursos.ForoHub.domain.autenticacion.UsuarioAutenticacion;
import com.AluraCursos.ForoHub.domain.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid UsuarioAutenticacion UsuarioAutenticacion) {

        Authentication authJWT = new UsernamePasswordAuthenticationToken(UsuarioAutenticacion.username(),
                UsuarioAutenticacion.password());
        var usuarioAutenticado = authenticationManager.authenticate(authJWT);
        var token = jwtService.generateToken((Usuario) usuarioAutenticado.getPrincipal() );
        return ResponseEntity.ok(new DatosJWToken(token));
}


}
