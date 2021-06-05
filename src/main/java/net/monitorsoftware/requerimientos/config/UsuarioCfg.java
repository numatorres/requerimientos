package net.monitorsoftware.requerimientos.config;

import net.monitorsoftware.requerimientos.model.Usuario;
import net.monitorsoftware.requerimientos.repository.UsuarioRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UsuarioCfg {

    // para crear registros de prueba en la primera ejecución

    /*
    @Bean
    CommandLineRunner commandLineRunner(UsuarioRep usuarioRep){
        return args -> {
            Usuario u1 = new Usuario (
                "usuario1@local",
                "Usuario UNO",
                "12345678",
                'A');
            Usuario u2 = new Usuario (
                    "usuario2@1local",
                    "Usuario DOS",
                    "12345678",
                    'A');
            usuarioRep.saveAll(List.of(u1,u2));
        };
    };*/
}

