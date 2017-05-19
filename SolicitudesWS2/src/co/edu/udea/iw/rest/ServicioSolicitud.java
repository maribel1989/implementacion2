package co.edu.udea.iw.rest;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
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

import co.edu.udea.iw.bl.SolicitudBL;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.dto.SolicitudWS;
import co.edu.udea.iw.exception.MyException;

@Path("Solicitud")
@Component
public class ServicioSolicitud {

	@Autowired
	private SolicitudBL solicitudBL;

	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@GET
	public List<SolicitudWS> obtener() throws RemoteException {

		List<SolicitudWS> solicitud = new ArrayList<SolicitudWS>();

		List<Solicitud> listaSolicitud = null;

		try {
			listaSolicitud = solicitudBL.obtener();

			for (Solicitud solicitudes : listaSolicitud) {

				SolicitudWS solicitudWS = new SolicitudWS();

				solicitudWS.setId(solicitudes.getId());
				solicitudWS.setFecha(solicitudes.getFecha());
				solicitudWS.setContenido(solicitudes.getContenido());

				solicitud.add(solicitudWS);
			}

		} catch (MyException e) {
			throw new RemoteException(e.getMessage());
		}
		return solicitud;
	}

	// Metodo para guardar una Solicitud
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	@POST
	public String guardarSolicitud(@QueryParam("Id") long id, @QueryParam("Fecha") Date fecha,
			@QueryParam("Contenido") String contenido) {
		try {
			solicitudBL.guardar(id, fecha, contenido);
		} catch (MyException e) {
			return e.getMessage();
		}
		return "El dato se ingresó correctamente";
	}

	// Metodo para actualizar una Solicitud
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	@PUT
	public String actualizarSolicitud(@QueryParam("Id") long id, @QueryParam("Fecha") Date fecha,
			@QueryParam("Contenido") String contenido) {
		try {
			solicitudBL.actualizar(id, fecha, contenido);
		} catch (MyException e) {
			return e.getMessage();
		}
		return "La solicitud se actualizó de forma correcta";
	}

	// Metodo para eliminar una Solicitud
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	@DELETE
	public String eliminarSolicitud(@QueryParam("Id") long id) {
		try {
			solicitudBL.eliminar(id);
		} catch (MyException e) {
			return e.getMessage();
		}
		return "";
	}

}
