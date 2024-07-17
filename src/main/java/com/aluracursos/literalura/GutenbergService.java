package com.aluracursos.literalura;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GutenbergService {

    private static final String GUTENDEX_API_URL = "https://gutendex.com/books";

    private final RestTemplate restTemplate;

    public GutenbergService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String buscarLibroPorTitulo(String titulo) {
        String url = UriComponentsBuilder.fromHttpUrl(GUTENDEX_API_URL)
                .queryParam("search", titulo)
                .build()
                .toUriString();

        return restTemplate.getForObject(url, String.class);
    }

    public String listarLibros() {
        return restTemplate.getForObject(GUTENDEX_API_URL, String.class);
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
