# Act2.Ens-Apr-Actividad-avanzada-API-REST-de-Libros-y-Autores
Aplicar relaciones entre entidades, búsquedas y ordenación en Spring Boot. 

# Herramientas utilizadas

     - Visual Studio Code
     - PostMan
     - SpringBoot

    
# Requisitos para su uso

    - Visual Studio Code
    - SpringBoot
    - Postman

# Estructura de carpetas


# Demostración de funcionalidades

## Apartado de libros


### GET	/api/v1/libros	Listar todos los libros
### GET	/api/v1/libros/{id}	Obtener libro por ID
### POST	/api/v1/libros	Crear nuevo libro (vincular a autor)
### PUT	/api/v1/libros/{id}	Actualizar libro
### DELETE	/api/v1/libros/{id}	Eliminar libro
### GET	/api/v1/libros/buscar	Buscar con filtros y ordenación

## Apartado de autores

### GET	/api/v1/autores	Listar autores
### GET	/api/v1/autores/{id}	Ver autor con sus libros
### POST	/api/v1/autores	Crear nuevo autor


## Reparto de tareas:  
Daniel: Clases relacionadas con Libros  
Jose: Clases relacionadas con Autores (Nota la variable "id" debe ser "id_autor")

Enlace a guia:
https://www.arquitecturajava.com/jpa-manytoone/ 

Cosas a solucionar: al intentar vincular autor y libro se genera un bucle infinito. Por algun motivo se vincula el libro al array del autor asignado
