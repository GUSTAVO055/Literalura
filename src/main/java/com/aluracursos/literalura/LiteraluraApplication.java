package com.aluracursos.literalura;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		// Configuración del RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// Contexto de Spring
		GutenbergService gutenbergService = new GutenbergService(restTemplate);

		do {
			// Mostrar el menú
			System.out.println("Menú Principal:");
			System.out.println("1. Buscar libro por título.");
			System.out.println("2. Listar libros registrados.");
			System.out.println("3. Listar autores registrados.");
			System.out.println("4. Listar autores vivos en un determinado año.");
			System.out.println("5. Listar libros por idioma.");
			System.out.println("6. Salir.");
			System.out.print("Seleccione una opción: ");

			// Leer la opción del usuario
			opcion = scanner.nextInt();
			scanner.nextLine(); // Consumir el salto de línea después de nextInt()

			// Evaluar la opción seleccionada
			switch (opcion) {
				case 1:
					System.out.println("Ingrese el título del libro a buscar:");
					String tituloBusqueda = scanner.nextLine();
					String resultadoBusquedaTitulo = gutenbergService.buscarLibroPorTitulo(tituloBusqueda);
					System.out.println("Resultados de la búsqueda por título:\n" + resultadoBusquedaTitulo);
					break;
				case 2:
					String resultadoListarLibros = gutenbergService.listarLibros();
					System.out.println("Listado de libros registrados:\n" + resultadoListarLibros);
					break;
				case 3:
					String resultadoListarAutores = gutenbergService.listarAutores();
					System.out.println("Listado de autores registrados:\n" + resultadoListarAutores);
					break;
				case 4:
					System.out.println("Ingrese el año para listar autores vivos:");
					int anio = scanner.nextInt();
					scanner.nextLine(); // Consumir el salto de línea después de nextInt()
					String resultadoListarAutoresVivos = gutenbergService.listarAutoresVivosEnAnio(anio);
					System.out.println("Listado de autores vivos en el año " + anio + ":\n" + resultadoListarAutoresVivos);
					break;
				case 5:
					System.out.println("Ingrese el idioma para listar libros:");
					String idioma = scanner.nextLine();
					String resultadoListarLibrosPorIdioma = gutenbergService.listarLibrosPorIdioma(idioma);
					System.out.println("Listado de libros en idioma " + idioma + ":\n" + resultadoListarLibrosPorIdioma);
					break;
				case 6:
					System.out.println("Saliendo del programa. ¡Hasta luego!");
					break;
				default:
					System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 6.");
			}

			System.out.println(); // Salto de línea para separar las iteraciones del menú

		} while (opcion != 6);

		// Cerrar el scanner al salir del bucle
		scanner.close();
	}

	// Configuración del RestTemplate como bean
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
