package cv.estudiantes;

import cv.estudiantes.modelo.Estudiante;
import cv.estudiantes.servicio.EstudianteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {

	@Autowired
	private EstudianteServicio estudianteServicio;

	private static final Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);

	String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion...");
		//Levantar fabrica Spring
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info("Aplicacion finalizada!");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(nl + "Ejecutando metodo run de Spring..." + nl);
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir){
			mostarMenu();
			salir = ejecutarOpciones(consola);
			logger.info(nl);
		}//fin while

	}

	private void mostarMenu(){
		//logger.info(nl);
		logger.info("""
				*** Sistema de Estudiantes ***
				1. Listar Estudiantes.
				2. Buscar Estudiante.
				3. Agregar Estudiante.
				4. Modificar Estudiante.
				5. Eliminar Estudiante.
				6. Salir.
				
				Elige una opcion: 
				""");
	}
	private boolean ejecutarOpciones(Scanner consola){
		var opcion = Integer.parseInt(consola.nextLine());
		var salir = false;
		switch (opcion){
			case 1 ->{//Listar Estudiantes
				logger.info(nl + "Listado de Estudiantes: " + nl);
				List<Estudiante> estudiantes = estudianteServicio.listarEstudiantes();
				estudiantes.forEach((estudiante -> logger.info(estudiante.toString() + nl)));
			}
			case 2 ->{//Buscar estudiante
			logger.info("Ingrese el ID a buscar: ");
			var id = Integer.parseInt(consola.nextLine());
			Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(id);
			if(estudiante != null)
				logger.info("Estudiante encontrado: " + estudiante + nl);
			else
				logger.info("Estudiante NO encontrado con id: " + id + nl);
			}
			case 3 ->{//Agregar Estudiante
				logger.info("Agregar Estudiante: " + nl);
				logger.info("Nombre: ");
				var nombre = consola.nextLine();
				logger.info("Apellido: ");
				var apellido = consola.nextLine();
				logger.info("Telefono: ");
				var telefono = consola.nextLine();
				logger.info("Email: ");
				var email = consola.nextLine();
				//Crear Estudiante sin ID
				var estudiante = new Estudiante();
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setTelefono(telefono);
				estudiante.setEmail(email);
				estudianteServicio.guardarEstudiante(estudiante);
				logger.info("Estudiante Agregado: " + estudiante + nl);
			}
			case 4 ->{//Modificar Estudiante
				logger.info("Modificar Estudiante: " + nl);
				logger.info("ID Estudiante: ");
				var id = Integer.parseInt(consola.nextLine());
				//Buscamos el estudiante a modificar
				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(id);
				if(estudiante != null){
					logger.info("Nombre: ");
					var nombre = consola.nextLine();
					logger.info("Apellido: ");
					var apellido = consola.nextLine();
					logger.info("Telefono: ");
					var telefono = consola.nextLine();
					logger.info("Email: ");
					var email = consola.nextLine();
					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setTelefono(telefono);
					estudiante.setEmail(email);
					estudianteServicio.guardarEstudiante(estudiante);
					logger.info("Estudiante Modificado: " + estudiante + nl);
				}else
					logger.info("Estudiante NO encontrado con ID: " + id + nl);
			}
			case 5 ->{//Eliminar Estudiante
				logger.info("Eliminar Estudiante: " + nl);
				logger.info("Ingrese el ID del Estudiante a eliminar: ");
				var id = Integer.parseInt(consola.nextLine());
				//Buscamos ID a eliminar
				var estudiante = estudianteServicio.buscarEstudiantePorId(id);
				if(estudiante != null){
					estudianteServicio.eliminarEstudiante(estudiante);
					logger.info("Estudiante Eliminado: " + estudiante + nl);
				}else
					logger.info("Estudiante NO encontrado con id: " + id);

			}
			case 6 ->{//Salir
				logger.info("Hasta Pronto!" + nl + nl);
				salir = true;

			}
			default -> logger.info("Opcion NO reconocida: " + opcion + nl);
		}//fin Switch

		return salir;
	}
}
