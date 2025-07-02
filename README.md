# 🎓 SistemaEstudiantesSpring

Aplicación web desarrollada con **Spring Boot** y **MySQL**, diseñada para gestionar estudiantes mediante una API RESTful. Este proyecto refuerza mis conocimientos en arquitectura por capas, persistencia con JPA y desarrollo backend con Spring.

---

## 📚 Descripción

Sistema que permite realizar operaciones CRUD (crear, leer, actualizar, eliminar) sobre registros de estudiantes, incluyendo atributos como nombre, apellido, email y teléfono. Implementado como una API RESTful, facilita la integración con aplicaciones frontend o servicios externos.

---

## 🚀 Tecnologías Utilizadas

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **MySQL**
- **Maven** (gestión de dependencias y construcción)
- **Postman** (para pruebas de la API)

---

## 🎯 Objetivos de Aprendizaje

- Implementar una arquitectura por capas (Controller, Service, Repository).
- Utilizar Spring Data JPA para la persistencia de datos.
- Diseñar y consumir una API RESTful.
- Gestionar la configuración de la base de datos con Spring Boot.
- Aplicar buenas prácticas en el desarrollo backend con Spring.

---

## 🧩 Funcionalidades Clave

- **GET /api/estudiantes**: Listar todos los estudiantes.
- **GET /api/estudiantes/{id}**: Obtener un estudiante por su ID.
- **POST /api/estudiantes**: Crear un nuevo estudiante.
- **PUT /api/estudiantes/{id}**: Actualizar los datos de un estudiante existente.
- **DELETE /api/estudiantes/{id}**: Eliminar un estudiante por su ID.

---

## ⚙️ Configuración & Ejecución

1. **Configura la base de datos MySQL**:

   - Crea una base de datos llamada `gestion_estudiantes`:

     ```sql
     CREATE DATABASE gestion_estudiantes;
     ```

   - Configura las credenciales de acceso en el archivo `src/main/resources/application.properties`:

     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/gestion_estudiantes
     spring.datasource.username=tu_usuario
     spring.datasource.password=tu_contraseña
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     ```

2. **Ejecuta la aplicación**:

   - Desde la línea de comandos:

     ```bash
     mvn spring-boot:run
     ```

   - O desde tu IDE preferido.

3. **Prueba la API**:

   - Utiliza herramientas como [Postman](https://www.postman.com/) para realizar peticiones HTTP a los endpoints mencionados.

---

## 📸 Capturas (próximamente)

Subiré capturas de la interacción con la API y ejemplos de peticiones/respuestas cuando estén disponibles.

---

## 🧠 Sobre el Autor

Este proyecto forma parte de mi portafolio como desarrollador backend, realizado durante mis estudios en **CFGS DAM**. Puedes ver más proyectos como este en mi perfil: [@ecalar](https://github.com/ecalar).

---

## ⚙️ Estado del Proyecto

✅ Funcional y estable — abierto a mejoras como autenticación JWT, validaciones con Bean Validation, documentación con Swagger o implementación de pruebas unitarias.

---

## 📩 Contacto

  Si te interesa saber más sobre mis proyectos:

- GitHub: [@ecalar](https://github.com/ecalar)
- Email: enriquecalar@gmail.com

---
