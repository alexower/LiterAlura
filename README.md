
# Books-Search ![Static Badge](https://img.shields.io/badge/Version-1.0-green)

Books-Search es una aplicación Java diseñada para gestionar y buscar libros y autores. Utiliza repositorios para interactuar con una base de datos que almacena información sobre libros y autores, permitiendo al usuario realizar diversas acciones a través de un menú interactivo.
## Características
- Buscar libros por título.
- Mostrar todos los libros registrados.
- Mostrar todos los autores registrados.
- Listar autores vivos en un determinado año.
- Mostrar libros por idioma.

## Requisitos

- Java 7
- Maven
- Dependencias de Spring Data JPA para la persistencia de datos
- Base de datos compatible con JPA (ej. MySQL, PostgreSQL, H2)
- Librerías para manejo de JSON y conexión a APIs externas

## Instalación

1. Clonar el repositorio:

    ```bash
    git clone https://github.com/alexower/LiterAlura.git
    ```

2. Importar el proyecto en tu IDE de preferencia (Eclipse, IntelliJ IDEA, etc.).

3. Configurar la base de datos en el archivo `application.properties`:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:yourhost/yourdatabase
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.jpa.hibernate.ddl-auto=update
    ```

4. Ejecutar la aplicación desde la clase principal `Principal`.

4. Ejemplo de ejecucion en consola
    
![Texto alternativo](https://raw.githubusercontent.com/alexower/LiterAlura/main/img/CapturaConsole.jpg)

## API utilizada

Este proyecto utiliza la [API de Gutendex](https://gutendex.com/) para acceder a una base de datos de libros del Proyecto Gutenberg.
La API permite buscar, obtener detalles y acceder a los textos completos de libros disponibles gratuitamente.

## Contribuciones

Para contribuir a este proyecto, por favor, sigue estos pasos:

1. Haz un fork del proyecto.
2. Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz commit (`git commit -am 'Agregar una nueva característica'`).
4. Haz push a la rama (`git push origin feature/nueva-caracteristica`).
5. Abre un Pull Request.


## Autor

Alex Milak




