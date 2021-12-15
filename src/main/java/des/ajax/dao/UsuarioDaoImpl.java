package des.ajax.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import des.ajax.entidades.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer crearUsuario(Usuario u) {

		return jdbcTemplate.update("INSERT INTO USUARIO (nombre, email) VALUES(?,?)", u.getNombre(), u.getEmail());

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
		return null;
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		return jdbcTemplate.query("SELECT * FROM USUARIO",
				(rs, rowNum) -> new Usuario(rs.getString("nombre"), rs.getString("email")));
	}
}
