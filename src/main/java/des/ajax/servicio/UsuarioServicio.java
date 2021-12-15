package des.ajax.servicio;

import des.ajax.entidades.Usuario;

import java.util.List;

public interface UsuarioServicio {

    public Usuario crearUsuario(Usuario u);

    public Boolean eliminarUsuario(String email);

    public Usuario modficiarUsuario (Usuario u);

    public Usuario obtenerUsuario(String email);

    public List<Usuario> obtenerUsuarios ();

}
