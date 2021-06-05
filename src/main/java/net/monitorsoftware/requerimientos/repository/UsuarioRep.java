package net.monitorsoftware.requerimientos.repository;

import net.monitorsoftware.requerimientos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRep extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findUsuariosByEmail(String email);
}
