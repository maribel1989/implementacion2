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

import co.edu.udea.iw.bl.Tipo_solicitudBL;
import co.edu.udea.iw.dto.Tipo_solicitud;
import co.edu.udea.iw.dto.Tipo_solicitudWS;
import co.edu.udea.iw.exception.MyException;

@Path("Tipo_solicitud")
@Component
public class ServicioTipo_solicitud {

	@Autowired
	private Tipo_solicitudBL tipo_solicitudBL;

	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@GET
	public List<Tipo_solicitudWS> obtener() throws RemoteException {

		List<Tipo_solicitudWS> tipo_solicitud = new ArrayList<Tipo_solicitudWS>();

		List<Tipo_solicitud> listaTipo_solicitud = null;

		try {
			listaTipo_solicitud = tipo_solicitudBL.obtener();

			for (Tipo_solicitud tipo_solicitudes : listaTipo_solicitud) {

				Tipo_solicitudWS tipo_SolicitudWS = new Tipo_solicitudWS();

				tipo_SolicitudWS.setId(tipo_solicitudes.getId());
				tipo_SolicitudWS.setNombre(tipo_solicitudes.getNombre());

				tipo_solicitud.add(tipo_SolicitudWS);
			}

		} catch (MyException e) {
			throw new RemoteException(e.getMessage());
		}
		return tipo_solicitud;
	}

	// Metodo para guardar una Tipo de solicitud
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	@POST
	public String guardarTipo_solicitud(@QueryParam("Id") long id, @QueryParam("Nombre") String nombre) {
		try {
			tipo_solicitudBL.guardar(id, nombre);
		} catch (MyException e) {
			return e.getMessage();
		}
		return "El dato se ingresó correctamente";
	}

	// Metodo para actualizar un Tipo de solicitud
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	@PUT
	public String actualizarDependencia(@QueryParam("Id") long id, @QueryParam("Nombre") String nombre) {
		try {
			tipo_solicitudBL.actualizar(id, nombre);
		} catch (MyException e) {
			return e.getMessage();
		}
		return "El tipo de solicitud se actualizó de forma correcta";
	}

	// Metodo para eliminar una tipo de solicitud
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	@DELETE
	public String eliminarDependencia(@QueryParam("Id") long id) {
		try {
			tipo_solicitudBL.eliminar(id);
		} catch (MyException e) {
			return e.getMessage();
		}
		return "";
	}

}
