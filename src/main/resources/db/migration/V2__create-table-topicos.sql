
create table topicos(

    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(50) NOT NULL,
    mensaje VARCHAR(500) NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    estado BOOLEAN NOT NULL,
    autor VARCHAR(50) NOT NULL,
    curso VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)

);


