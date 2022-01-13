package des.ajax.dao;

import java.util.List;

import des.ajax.entidades.Usuario;

public interface UsuarioDao extends DaoGenerico<Usuario>{

    public Usuario obtenerUsuarioPorEmail(String email);

    public List<Usuario> obtenerUsuarios ();

}
