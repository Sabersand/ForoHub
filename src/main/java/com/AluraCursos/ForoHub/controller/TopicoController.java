package com.AluraCursos.ForoHub.controller;

import com.AluraCursos.ForoHub.domain.posts.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;


    @PostMapping("/registrar")
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                                UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = new Topico(datosRegistroTopico);
        topico.setFechaCreacion(LocalDate.now().toString());
        topico.setEstado(true);
        topicoRepository.save(topico);
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getUsuarioId(), topico.getMensaje(), topico.getFechaCreacion(), topico.getEstado());


        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(datosRespuestaTopico);
    }


    @GetMapping("/listarTopicos")
    public ResponseEntity<Page<DatosListadoTopico>> listarTopicos(@PageableDefault(size = 5) Pageable paginacion){
        Page<Topico> topicos = topicoRepository.findByEstadoTrue(paginacion);
        Page<DatosListadoTopico> datosListadoTopicos = topicos.map(DatosListadoTopico::new);
        return ResponseEntity.ok(datosListadoTopicos);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        topicoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/actualizar")
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizacionTopico datosActualizacionTopico){

        Optional<Topico> topico = topicoRepository.findById(datosActualizacionTopico.id());

        if(topico.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        topico.get().actualizarTopico(datosActualizacionTopico);
        return ResponseEntity.ok().build();


    }


}
