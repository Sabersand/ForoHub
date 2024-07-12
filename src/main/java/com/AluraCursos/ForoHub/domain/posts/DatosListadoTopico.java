package com.AluraCursos.ForoHub.domain.posts;

public record DatosListadoTopico(Long id, String usuarioId, String titulo, String fechaCreacion, Boolean estado) {

    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getUsuarioId(), topico.getTitulo(), topico.getFechaCreacion(), topico.getEstado());
}


}
