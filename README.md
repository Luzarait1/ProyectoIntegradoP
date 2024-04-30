
# Rest API: Sistema Kanban
### Bootcamp Backend - Makaia
### Abril 30, 2024

## Descripción del Proyecto
El proyecto integrador tiene como fin demostrar las habilidades que se aprendieron en el Bootcamp de Backend de Makaia. Aquí, se implementará las tecnologías aprendidas y trabajadas a lo largo de las clases.

Este proyecto consiste en desarrollar una REST API la cual es basada en Springboot y Java. Aquí, se quiere tener una gestión de los proyectos y las tareas creadas y utilizadas en el método Kanban; de esta manera, la API permite organizar los proyectos y las tareas en diferentes etapas, al igual que realizar un seguimiento de estas. 

## Problema a Resolver
Debido a que la implementación manual de un Kanban Board puede ser tediosa, la API pretende automatizar un poco este proceso, permitiendo una gestión eficiente de los proyectos y los flujos de trabajo, permitiendo que un usuario pueda organizar sus tareas organizadamente.

## Diagrama Entidad - Relacion
![Diagrama E-R](/ModeloER.PNG)

## Diagrama UML
![Diagrama UML](/ModeloUML.PNG)

## Ejemplo: Flujo del Proyecto
![Flujo del Proyecto](/FlujoProyecto.PNG)

### Las principales tecnologías que se utilizaron son:
- Java y Springboot: En el backend y el framework
- JPA: Para el modelo de datos
- Swagger: Para la documentación
- MySQL: Permite el almacenamiento de la base de datos
- Integración continua
- Buenas prácticas de desarrollo

## Principales Características
La API permite:
1. Gestionar Proyectos: Aquí, se permite realizar las operaciones CRUD a los proyectos
2. Gestionar Tareas: Facilita la creación, eliminación y obtención de las tareas que se encuentran dentro de un proyecto
3. Seguimiento de Proyectos y Tareas: Se permite realizar un seguimiento a los proyectos (estado: ACTIVE, INACTIVE, o PAUSED) y a las tareas (TO DO, IN PROGRESS, BLOCKED o DONE) 

## Instalación
Para poder correr la aplicación efectivamente:
- Clonar el repositorio
- Actualizar las credenciales del MySQL en application.properties
- Ejecutar la aplicación
 
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
