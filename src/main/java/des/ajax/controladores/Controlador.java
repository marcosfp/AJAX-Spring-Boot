package des.ajax.controladores;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import des.ajax.entidades.Usuario;
import des.ajax.servicio.UsuarioServicio;

@Controller
public class Controlador {

	@Autowired
	UsuarioServicio usuarioServicio;

	@RequestMapping(method = RequestMethod.GET, value = { "/", "/index" })
	public String getIndex() {
		return "index";
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "crear")
	public Usuario crearUsuario(@RequestBody Usuario usuario) {

		return usuarioServicio.crearUsuario(new Usuario(usuario.getNombre(), usuario.getEmail()));
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "crear2")
	public ResponseEntity<Object> crearUsuariocon2(@RequestBody Map<String, String> json) {

		Usuario usuario = usuarioServicio.crearUsuario(new Usuario(json.get("nombre"), json.get("email")));
        
		if (usuario != null)
			return new ResponseEntity<Object>(usuario, HttpStatus.OK);
		else
	        return new ResponseEntity<Object>(new Error("Email ya existente"),HttpStatus.FORBIDDEN);


	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "todos")
	public List<Usuario> obtenerTodos() {

		return usuarioServicio.obtenerUsuarios();
	}
}
