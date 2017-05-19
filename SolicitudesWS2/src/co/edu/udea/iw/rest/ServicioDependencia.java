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

import co.edu.udea.iw.bl.DependenciaBL;
import co.edu.udea.iw.dto.Dependencia;
import co.edu.udea.iw.dto.DependenciaWS;
import co.edu.udea.iw.exception.MyException;

@Path("Dependencia")
@Component
public class ServicioDependencia {

	@Autowired
	private DependenciaBL dependenciaBL;

	@Path("list")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@GET
	public List<DependenciaWS> obtener() throws RemoteException {

		List<DependenciaWS> dependencia = new ArrayList<DependenciaWS>();

		List<Dependencia> listaDependencia = null;

		try {
			listaDependencia = dependenciaBL.obtener();

			for (Dependencia dependencias : listaDependencia) {

				DependenciaWS dependenciaWS = new DependenciaWS();

				dependenciaWS.setId(dependencias.getId());
				dependenciaWS.setNombre(dependencias.getNombre());

				dependencia.add(dependenciaWS);
			}

		} catch (MyException e) {
			throw new RemoteException(e.getMessage());
		}
		return dependencia;
	}

	// Metodo para guardar una dependencia
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	@POST
	public String guardarDependencia(@QueryParam("Id") long id, @QueryParam("Nombre") String nombre) {
		try {
			dependenciaBL.guardar(id, nombre);
		} catch (MyException e) {
			return e.getMessage();
		}
		return "El dato se ingresó correctamente";
	}

	// Metodo para actualizar una dependencia
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	@PUT
	public String actualizarDependencia(@QueryParam("Id") long id, @QueryParam("Nombre") String nombre) {
		try {
			dependenciaBL.actualizar(id, nombre);
		} catch (MyException e) {
			return e.getMessage();
		}
		return "La dependencia se actualizó de forma correcta";
	}

	// Metodo para eliminar una dependencia
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	@DELETE
	public String eliminarDependencia(@QueryParam("Id") long id) {
		try {
			dependenciaBL.eliminar(id);
		} catch (MyException e) {
			return e.getMessage();
		}
		return "";
	}
}
