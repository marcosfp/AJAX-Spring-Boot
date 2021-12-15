package des.ajax.servicio;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import des.ajax.dao.UsuarioDao;
import des.ajax.entidades.Usuario;

@Service
@Transactional
public class UsuarioServicioImpl implements UsuarioServicio{

    @Autowired
    UsuarioDao usuarioDao;


    @Override
    public Usuario crearUsuario(Usuario u) {
        try {
            Integer resultado = usuarioDao.crearUsuario(u);
            return u;
        } catch (DataAccessException dae) {

            return null;
        }
        }


    @Override
    public Boolean eliminarUsuario(String email) {
        return null;
    }

    @Override
    public Usuario modficiarUsuario(Usuario u) {
        return null;
    }

    @Override
    public Usuario obtenerUsuario(String email) {
        return usuarioDao.obtenerUsuario(email);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuarioDao.obtenerUsuarios();
    }
}
