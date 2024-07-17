package com.aluracursos.literalura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GutenbergService {

    private static final String GUTENDEX_API_URL = "https://gutendex.com/books";

    private final RestTemplate restTemplate;

    @Autowired
    public GutenbergService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String buscarLibroPorTitulo(String titulo) {
        String url = UriComponentsBuilder.fromHttpUrl(GUTENDEX_API_URL)
                .queryParam("search", titulo)
                .build()
                .toUriString();

        // Realizamos la llamada GET a la API y obtenemos la respuesta como String
        return restTemplate.getForObject(url, String.class);
    }

    public String listarLibros() {
        String url = UriComponentsBuilder.fromHttpUrl(GUTENDEX_API_URL)
                .queryParam("page", 1) // Añadimos el parámetro 'page' para la paginación
                .build()
                .toUriString();

        return restTemplate.getForObject(url, String.class);

    }

    public String listarAutores() {
        String url = UriComponentsBuilder.fromHttpUrl(GUTENDEX_API_URL + "/authors")
                .build()
                .toUriString();

        return restTemplate.getForObject(url, String.class);
    }

    public String listarAutoresVivosEnAnio(int anio) {
        String url = UriComponentsBuilder.fromHttpUrl(GUTENDEX_API_URL + "/authors")
                .queryParam("aliveIn", anio)
                .build()
                .toUriString();

        return restTemplate.getForObject(url, String.class);
    }

    public String listarLibrosPorIdioma(String idioma) {
        String url = UriComponentsBuilder.fromHttpUrl(GUTENDEX_API_URL)
                .queryParam("languages", idioma)
                .build()
                .toUriString();

        return restTemplate.getForObject(url, String.class);
    }
}