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

import co.edu.udea.iw.bl.RespuestaBL;
import co.edu.udea.iw.dto.Respuesta;
import co.edu.udea.iw.dto.RespuestaWS;
import co.edu.udea.iw.exception.MyException;

@Path("Respuesta")
@Component
public class ServicioRespuesta {

	@Autowired
	private RespuestaBL respuestaBL;

	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@GET
	public List<RespuestaWS> obtener() throws RemoteException {

		List<RespuestaWS> respuesta = new ArrayList<RespuestaWS>();

		List<Respuesta> listaRespuesta = null;

		try {
			listaRespuesta = respuestaBL.obtener();

			for (Respuesta respuestas : listaRespuesta) {

				RespuestaWS respuestaWS = new RespuestaWS();

				respuestaWS.setId(respuestas.getId());
				respuestaWS.setSolicitud_Id(respuestas.getSolicitud_Id());
				;
				respuestaWS.setUsuario_Id(respuestas.getUsuario_Id());
				respuestaWS.setFecha(respuestas.getFecha());
				respuestaWS.setContenido(respuestas.getContenido());

				respuesta.add(respuestaWS);
			}

		} catch (MyException e) {
			throw new RemoteException(e.getMessage());
		}
		return respuesta;
	}

	// Metodo para guardar una Respuesta
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	@POST
	public String guardarRespuesta(@QueryParam("Id") long id, @QueryParam("fecha") Date fecha,
			@QueryParam("contenido") String contenido) {
		try {
			respuestaBL.guardar(id, fecha, contenido);
		} catch (MyException e) {
			return e.getMessage();
		}
		return "La respuesta ha sido guardada";
	}

	// Metodo para actualizar una Respuesta
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	@PUT
	public String actualizarRespuesta(@QueryParam("Id") long id, @QueryParam("Contenido") String contenido) {
		try {
			respuestaBL.actualizar(id, contenido);
		} catch (MyException e) {
			return e.getMessage();
		}
		return "La dependencia se actualizó de forma correcta";
	}

	// Metodo para eliminar una respuesta
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	@DELETE
	public String eliminarDependencia(@QueryParam("Id") long id) {
		try {
			respuestaBL.eliminar(id);
		} catch (MyException e) {
			return e.getMessage();
		}
		return "La respuesta se eliminó con exito";
	}
}
