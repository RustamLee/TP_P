# gestion_hotelera
Trabajo práctico en grupo.  Universidad Tecnológica Nacional, Mar del Plata
UML diagram: https://drive.google.com/file/d/1h1cFOmklX779Gvo-TJU82N4HqMNciffV/view?usp=sharing

Bloques de proyecto:
1) Gestión de usuarios. Almacenamiento de datos y seguridad
Funciones implementadas para la gestión de usuarios y sus contraseñas.
Implementación del mecanismo de almacenamiento de datos:
Leer y escribir usuarios y reservas en archivos (JSON/ texto).
Hashing de contraseñas. Configure el manejo de excepciones y el registro para gestionar los errores.
IMPORTANTE:
- Sólo el Administrador puede agregar un nuevo empleado al sistema,
- El cliente tiene acceso al sistema sólo si tiene una reserva activa,
- Después de agregar un nuevo empleado al sistema o crear reservas para un cliente, se crea una contraseña por defecto (número de DNI), que debe cambiarse la primera vez que inicia sesión en el sistema. Login es email. 

   
3) Gestión de reservas
Implementación de lógica de gestión de habitaciones y reservas:
Métodos de check-in, check-out y consulta de disponibilidad de habitaciones.
Almacenamiento de información sobre reservas.
Manejo de excepciones

5) Interfaz de usuario
Desarrollo de una interfaz para la interacción con los usuarios:
Interfaz de consola o interfaz gráfica de usuario (GUI).
Creación de métodos de login, registro y reserva de salas.
Integración de la interfaz de usuario con la lógica de negocio.
Procesar solicitudes de usuarios y mostrar información.
Hay que hacer 3 varios de menu: para admin, recepcionista, cliente. Al usuario se le mostrará el menú que corresponde a su rol de usuario (ADMINISTRADOR, CLIENTE, RECEPCIONISTA). 

Integración general
Al finalizar cada parte:
Reuniones periódicas para discutir el progreso y la integración de componentes.
Un repositorio de código común pero cada uno tiene su propia rama.
Prepare documentación que explique cómo interactúa cada componente con los demás.
