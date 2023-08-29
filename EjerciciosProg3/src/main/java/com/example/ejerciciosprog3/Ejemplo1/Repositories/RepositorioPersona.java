package com.example.ejerciciosprog3.Ejemplo1.Repositories;

import com.example.ejerciciosprog3.Ejemplo1.Entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPersona extends JpaRepository<Persona, Long> {
}
