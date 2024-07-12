ForoHub
ForoHub es un prototipo de foro desarrollado en Java desde la perspectiva de un back-end developer. Proporciona una API con los siguientes endpoints:

- Registro de usuario
  POST /registro: Registra un nuevo usuario en el sistema.
- Inicio de sesión
  POST /login: Autentica al usuario y devuelve un token de acceso (Bearer token).
- Creación de un nuevo tema
  POST /topicos/registrar: Crea un nuevo tema en el foro.
- Actualización de un tema existente
  PUT /topicos/actualizar: Actualiza los detalles de un tema existente.
- Eliminación de un tema
  DELETE /topicos/{id}: Elimina un tema del foro.
- Obtención de detalles de un tema específico
  GET /topicos/listarTopicos: Obtiene los detalles de un tema específico.

**Configuración
  Asegúrate de tener Java y Maven instalados en tu entorno de desarrollo.
  Configura la base de datos (por ejemplo, MySQL o PostgreSQL) en tu archivo application.properties.
  Implementa la lógica de seguridad y autenticación utilizando un Bearer token.

**Ejecución
  Clona este repositorio.
  Navega al directorio del proyecto.
  Ejecuta ForoHubApplication para iniciar la aplicación.

**Tratamiento de errores
  El proyecto maneja errores comunes, como respuestas 404 (no encontrado) y 401 (no autorizado).
  Asegúrate de personalizar los mensajes de error según tus necesidades.
