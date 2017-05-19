package co.edu.udea.iw.bl.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.bl.UsuarioBL;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

@Transactional
public class UsuarioBLImpl implements UsuarioBL {

	private UsuarioDAO usuarioDAO;

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	//Metodo que obtiene una lista de usuarios
	@Override
	public List<Usuario> obtener() throws MyException {
		return usuarioDAO.get();
	}

	//Metodo para guardar un nuevo usuario en el sistema
	@Override
	public void guardar(Long id, String nombre, String apellido, String telefono, String email) throws MyException {

		Usuario usuario = null;

		// Validación para que el campo id no este vacio
		if (id == null) {
			throw new MyException("El id del usuario no puede ser vacio");
		}

		// Validación para que el campo nombre no este vacio
		if (nombre == null || nombre.isEmpty()) {
			throw new MyException("El nombre del usuario no puede ser vacio");
		}

		// Validación para que el campo apellido no este vacio
		if (apellido == null || apellido.isEmpty()) {
			throw new MyException("El apellido del usuario no puede ser vacio");
		}
		// Validación para que el campo email no este vacio
		if (email == null || email.isEmpty()) {
			throw new MyException("El correo del usuario no puede ser vacio");
		}
		// Validacion para que el usuario no se repita
		if (usuarioDAO.get(id) != null) {
			throw new MyException("Exixte en el sistema un usuario con esa id");
		}

		usuario = new Usuario();
		usuario.setId(id);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setTelefono(telefono);
		usuario.setEmail(email);

		usuarioDAO.insert(usuario);
	}

	//Metodo para actualizar un usuario del sistema
	@Override
	public void actualizar(Long id, String nombre, String apellido, String telefono, String email) throws MyException {

		Usuario usuario = null;

		// Validación para que el campo id no este vacio
		if (id == null) {
			throw new MyException("El id del usuario no puede ser vacio");
		}

		// Validación para que el campo nombre no este vacio
		if (nombre == null || nombre.isEmpty()) {
			throw new MyException("El nombre del usuario no puede ser vacio");
		}

		// Validación para que el campo apellido no este vacio
		if (apellido == null || apellido.isEmpty()) {
			throw new MyException("El apellido del usuario no puede ser vacio");
		}
		// Validación para que el campo email no este vacio
		if (email == null || email.isEmpty()) {
			throw new MyException("El correo del usuario no puede ser vacio");
		}

		usuario = usuarioDAO.get(id);

		if (usuario == null) {
			throw new MyException("El usuario a modificar no existe en el sistema");
		}

		// retiro id proque es la clave primaria
		// dependencia.setId(id);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setTelefono(telefono);
		usuario.setEmail(email);

		usuarioDAO.update(usuario);
	}

	// Metodo para eliminar un Usuario
	@Override
	public void eliminar(Long id) throws MyException {

		Usuario usuario = null;

		// Validación para que el campo id no este vacio
		if (id == null) {
			throw new MyException("El id el usuario no puede ser vacia");
		}

		usuario = usuarioDAO.get(id);

		if (usuario == null) {
			throw new MyException("El usuario a eliminar no existe en el sistema");
		}
		usuarioDAO.delete(usuario);
	}
}
