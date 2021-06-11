package net.monitorsoftware.requerimientos.controller;

import net.monitorsoftware.requerimientos.model.Usuario;
import net.monitorsoftware.requerimientos.service.UsuarioSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/usuario")
public class UsuarioCrtl {

    private final UsuarioSrv usuarioSrv;

    @Autowired
    public UsuarioCrtl(UsuarioSrv usuarioSrv) {
        this.usuarioSrv = usuarioSrv;
    }

    @GetMapping
    public List<Usuario> getUsuarios(){
        return usuarioSrv.getUsuarios();
    }

    @PostMapping
    public void registrarUsuario(@RequestBody Usuario usuario) {
        try{usuarioSrv.agregarUsuario(usuario);}
        catch (Exception e) {System.out.println(e.toString());}
    }

    @DeleteMapping(path="{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        try{usuarioSrv.eliminarUsuario(usuarioId);}
        catch (Exception e) {System.out.println(e.toString());}
    }

    @PutMapping(path="{usuarioId}")
    public void actualizarUsuario(
            @PathVariable("usuarioId") Long usuarioId,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String contrasena,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) char estado){
        usuarioSrv.actualizarUsuario(usuarioId,nombre,contrasena,email,estado);
    }
}


