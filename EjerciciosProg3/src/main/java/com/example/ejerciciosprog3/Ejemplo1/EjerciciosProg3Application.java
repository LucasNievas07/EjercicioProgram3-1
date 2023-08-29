package com.example.ejerciciosprog3.Ejemplo1;

import com.example.ejerciciosprog3.Ejemplo1.Entities.Persona;
import com.example.ejerciciosprog3.Ejemplo1.Repositories.RepositorioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EjerciciosProg3Application {

    @Autowired
    RepositorioPersona respositorioPersona;

    public static void main(String[] args) {


        SpringApplication.run(EjerciciosProg3Application.class, args);
        System.out.println("Funciona");
    }

    @Bean
    CommandLineRunner init(RepositorioPersona repositorioPersona) {
        return args -> {
            Persona persona = new Persona();
            persona.setNombre("Santiago");
            persona.setApellido("Villanueva");
            persona.setEdad(40);

            repositorioPersona.save(persona);

            Persona personaRecuperada = repositorioPersona.findById(persona.getId()).orElse(null);
            if (personaRecuperada != null) {
                System.out.println("Nombre: " + personaRecuperada.getNombre());
                System.out.println("Apellido: " + personaRecuperada.getApellido());
                System.out.println("Edad: " + personaRecuperada.getEdad());
            }
        };
    }
}
