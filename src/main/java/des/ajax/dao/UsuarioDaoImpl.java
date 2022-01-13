package des.ajax.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import des.ajax.entidades.Usuario;

@Repository
public class UsuarioDaoImpl extends DaoGenericoImpl<Usuario> implements UsuarioDao {

	@Override
	public Usuario obtenerUsuarioPorEmail(String email) {
		Query query = this.em.createQuery("SELECT u FROM Usuario u WHERE email= :valor");
		query.setParameter("valor", email);
		Usuario u = (Usuario) query.getSingleResult();

		return u;

	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		
		Query query = this.em.createQuery("SELECT u FROM Usuario u");
		List<Usuario> listaU = (List<Usuario>) query.getResultList();
		return listaU;
	}
}
