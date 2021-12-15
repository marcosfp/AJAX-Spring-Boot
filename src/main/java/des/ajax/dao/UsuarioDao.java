package des.ajax.dao;

import java.util.List;

import des.ajax.entidades.Usuario;

public interface UsuarioDao {

    public Integer crearUsuario(Usuario u);

    public Boolean eliminarUsuario(String email);

    public Usuario modficiarUsuario (Usuario u);

    public Usuario obtenerUsuario(String email);

    public List<Usuario> obtenerUsuarios ();

}
