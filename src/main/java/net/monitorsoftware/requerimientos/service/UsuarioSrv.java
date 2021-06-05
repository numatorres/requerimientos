package net.monitorsoftware.requerimientos.service;

import net.monitorsoftware.requerimientos.model.Usuario;
import net.monitorsoftware.requerimientos.repository.UsuarioRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioSrv {

    @Autowired
    public UsuarioSrv(UsuarioRep usuarioRep) {
        this.usuarioRep = usuarioRep;
    }

    private final UsuarioRep usuarioRep;

    public List<Usuario> getUsuarios() {
        return usuarioRep.findAll(Sort.by("id"));
    }

    public void agregarUsuario(Usuario usuario) {

        Optional<Usuario> usuarioPorEmail = usuarioRep.findUsuariosByEmail(usuario.getEmail());
        if (usuarioPorEmail.isPresent()) {
            throw new IllegalStateException("Email Ya Existe");
        }
        else {
            System.out.println(usuario);
            usuarioRep.save(usuario);
        }
    }

    public void eliminarUsuario(Long usuarioId)  {
        if (usuarioRep.existsById(usuarioId)){ usuarioRep.deleteById(usuarioId);  }
        else { throw new IllegalStateException("Usuario ID: "+usuarioId+" NO existe"); }
    }

    @Transactional
    public void actualizarUsuario(Long usuarioId, String nombre, String contrasena, String email, char estado) {
        Usuario usuario = usuarioRep.findById(usuarioId) .orElseThrow(()->new IllegalStateException("Usuario ID: "+usuarioId + " No existe"));

        if (nombre != null && nombre.length()>0 && !Objects.equals(usuario.getNombre(),nombre)) {usuario.setNombre(nombre);}
        if (contrasena != null && contrasena.length()>0 && !Objects.equals(usuario.getContrasena(),contrasena)) {usuario.setContrasena(contrasena);}
        if (email != null && !Objects.equals(usuario.getEstado(),email)) {
            Optional<Usuario> usuarioOpcional = usuarioRep.findUsuariosByEmail(email);
            if (usuarioOpcional.isPresent()) {throw new IllegalStateException("Correo Ya Existe!"); }
            else {usuario.setEmail(email);}
        }
        // A = Activo -- I = Inactivo
        if ((estado == 'A' || estado == 'I') && !Objects.equals(usuario.getEstado(),estado)) {usuario.setEstado(estado);}
    }
}