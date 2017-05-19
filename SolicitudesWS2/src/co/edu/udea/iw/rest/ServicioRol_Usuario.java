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

import co.edu.udea.iw.bl.Rol_UsuarioBL;
import co.edu.udea.iw.dto.Rol_Usuario;
import co.edu.udea.iw.dto.Rol_UsuarioWS;
import co.edu.udea.iw.exception.MyException;

@Path("Rol_Usuario")
@Component
public class ServicioRol_Usuario {

	@Autowired
	private Rol_UsuarioBL rol_UsuarioBL;

	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@GET
	public List<Rol_UsuarioWS> obtener() throws RemoteException {

		List<Rol_UsuarioWS> rol_Usuario = new ArrayList<Rol_UsuarioWS>();

		List<Rol_Usuario> listaRol_Usuario = null;

		try {
			listaRol_Usuario = rol_UsuarioBL.obtener();

			for (Rol_Usuario rol_Usuarios : listaRol_Usuario) {

				Rol_UsuarioWS rol_UsuarioWS = new Rol_UsuarioWS();

				rol_UsuarioWS.setId(rol_Usuarios.getId());
				rol_UsuarioWS.setTipo_Rol(rol_Usuarios.getTipo_Rol());

				rol_Usuario.add(rol_UsuarioWS);
			}

		} catch (MyException e) {
			throw new RemoteException(e.getMessage());
		}
		return rol_Usuario;
	}

	// Metodo para guardar un Rol de Usuario
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	@POST
	public String guardarDependencia(@QueryParam("Id") long id, @QueryParam("tipo_Rol") String tipo_Rol) {
		try {
			rol_UsuarioBL.guardar(id, tipo_Rol);
		} catch (MyException e) {
			return e.getMessage();
		}
		return "El rol de usuario se ingreso correctamente";
	}

	// Metodo para actualizar un Rol de Usuario
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	@PUT
	public String actualizarDependencia(@QueryParam("Id") long id, @QueryParam("tipo_Rol") String tipo_Rol) {
		try {
			rol_UsuarioBL.actualizar(id, tipo_Rol);
		} catch (MyException e) {
			return e.getMessage();
		}
		return "La dependencia se actualizó de forma correcta";
	}

	// Metodo para eliminar un Rol de Usuario
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	@DELETE
	public String eliminarDependencia(@QueryParam("Id") long id) {
		try {
			rol_UsuarioBL.eliminar(id);
		} catch (MyException e) {
			return e.getMessage();
		}
		return "El rol se ha eliminado";
	}

}
