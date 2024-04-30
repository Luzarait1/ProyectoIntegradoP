
# Rest API: Sistema Kanban
### Bootcamp Backend - Makaia
### Abril 30, 2024


## Descripcion del Proyecto
El proyecto integrador tiene como fin demostrar las habilidades que se aprendieron en el Bootcamp de Backend de Makaia. Aqui, se implementara las tecnologias aprendidas y trabajadas a lo largo de las clases.

Este proyecto consiste en desarrollar una REST API la cual es basada en Springboot y Java. Aqui, se quiere tener una gestion de los proyectos y las tareas creadas y utilizadas en el metodo Kanban; de esta manera, la API permite organizar los proyectos y las tareas en diferentes etapas, al igual que realizar un seguimiento de estas. 

## Problema a Resolver
Debido a que la implementacion manual de un Kanban Board puede ser tediosa, la API pretende automatizar un poco este proceso, permitiendo una gestion eficiente de los proyectos y los flujos de trabajo, permitiendo que un usuario pueda organizar sus tareas organizadamente. 

## Diagrama Entidad - Relacion

### Las principales tecnologias que se utilizaron son :
- Java y Springboot: En el backend y el framework
- JPA: Para el modelo de datos
- Swagger: Para la documentacion
- MySQL: Permite el almacenamiento de la base de datos
- Integracion continua
- Buenas practicas de desarrollo

## Principales Caracteristicas
La API permite:
1. Gestionar Proyectos: Aqui, se permite realizar las operaciones CRUD a los proyectos
2. Gestionar Tareas: Facilita la creacion, eliminacion y obtencion de las tareas que se encuentran dentro de un proyecto
3. Seguimiento de Proyectos y Tareas: Se permite realizar un seguimiento a los proyectos (estado: ACTIVE, INACTIVE, o PAUSED) y a las tareas (TO DO, IN PROGRESS, BLOCKED o DONE) 

## Instalacion
Para poder correr la aplicacion efectivamente:
- Clonar el repositorio
- Actualizar las credenciales del MySQL en application.properties
- Ejecutar la aplicacion
 
## Endpoints para Proyecto

#### POST - Crear un proyecto
Endpoint: ```/v1/proyecto/```

Ejemplo de body de la solicitud: 
```
{
  "nombre": "Proyecto 15",
  "descripcion": "Descripcion del proyecto"
}
```

#### PUT - Editar un proyecto
Endpoint: ```/v1/proyecto/idProyecto```

Ejemplo de body de la solicitud: 

PathVariable: ```/v1/proyecto/1```

RequestBody:
```
{
  "nombre": "Proyecto 14",
  "descripcion": "Descripcion del proyecto",
  "status": "PAUSED",
  "createdDate": "2024-04-27T20:22:32.538771",
  "lastUpdatedDate": "2024-04-28T20:22:32.538771",
  "listaTareas": []	
}
```

#### GET - Obtener un proyecto
Endpoint: ```/v1/proyecto/idProyecto```

Ejemplo de body de la solicitud: 

PathVariable: 
```
/v1/proyecto/1
```

#### DELETE - Eliminar un proyecto
Endpoint: ```/v1/proyecto/idProyecto```

Ejemplo de body de la solicitud: 

PathVariable: 
```
/v1/proyecto/1
```

## Endpoints para Tarea

#### POST - Crear una tarea
Endpoint: ```/v1/tarea/proyecto/idProyecto```

Ejemplo de body de la solicitud: 

PathVariable: ```/v1/tarea/proyecto/1```

RequestBody:
```
{
	"nombre": "Tarea 2",
	"descripcion": "Descripcion de tarea",
	"tipo": "BUG",
	"startDate": "2024-05-15",
	"dueDate": "2024-06-01"
}
```

#### GET - Obtener una tarea
Endpoint: ```/v1/tarea/idTarea```

Ejemplo de body de la solicitud: 

PathVariable: 
```
/v1/tarea/1
```

#### DELETE - Eliminar una tarea 
Endpoint: ```/v1/tarea/idTarea```

Ejemplo de body de la solicitud: 

PathVariable: 
```
/v1/tarea/1
```
