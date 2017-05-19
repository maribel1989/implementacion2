package co.edu.udea.iw.rest;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.bl.UsuarioBL;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.dto.UsuarioWS;
import co.edu.udea.iw.exception.MyException;

@Path("Usuario")
@Component
public class ServicioUsuario {

	@Autowired
	private UsuarioBL usuarioBL;

	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@GET
	public List<UsuarioWS> obtener() throws RemoteException {

		List<UsuarioWS> usuario = new ArrayList<UsuarioWS>();

		List<Usuario> listaUsuario = null;

		try {
			listaUsuario = usuarioBL.obtener();

			for (Usuario usuarios : listaUsuario) {

				UsuarioWS usuarioWS = new UsuarioWS();

				usuarioWS.setId(usuarios.getId());
				usuarioWS.getDependencia_id();
				usuarioWS.setNombre(usuarios.getNombre());
				usuarioWS.setApellido(usuarios.getApellido());
				usuarioWS.setTelefono(usuarios.getTelefono());

				usuario.add(usuarioWS);
			}

		} catch (MyException e) {
			throw new RemoteException(e.getMessage());
		}
		return usuario;
	}

	// Metodo para guardar un Usuario
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	@POST
	public String guardarUsuario(@QueryParam("Id") long id, @QueryParam("Nombre") String nombre,
			@QueryParam("Apellido") String apellido, @QueryParam("Telefono") String telefono,
			@QueryParam("Email") String email) {
		try {
			usuarioBL.guardar(id, nombre, apellido, telefono, email);
		} catch (MyException e) {
			return e.getMessage();
		}
		return "El usuario se ingresó correctamente";
	}

	// Metodo para actualizar un Usuario
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	@PUT
	public String actualizarUsuario(@QueryParam("Id") long id, @QueryParam("Nombre") String nombre,
			@QueryParam("Apellido") String apellido, @QueryParam("Telefono") String telefono,
			@QueryParam("Email") String email) {
		try {
			usuarioBL.actualizar(id, nombre, apellido, telefono, email);
		} catch (MyException e) {
			return e.getMessage();
		}
		return "El usuario se actualizó de forma correcta";
	}

	// Metodo para eliminar un Usuario
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	@DELETE
	public String eliminarUsuario(@QueryParam("Id") long id) {
		try {
			usuarioBL.eliminar(id);
		} catch (MyException e) {
			return e.getMessage();
		}
		return "";
	}

}
