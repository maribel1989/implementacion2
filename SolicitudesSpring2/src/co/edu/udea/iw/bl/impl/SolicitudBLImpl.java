package co.edu.udea.iw.bl.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.bl.SolicitudBL;
import co.edu.udea.iw.dao.SolicitudDAO;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.MyException;

@Transactional

public class SolicitudBLImpl implements SolicitudBL {
	private SolicitudDAO solicitudDAO;

	public SolicitudDAO getClienteDAO() {
		return solicitudDAO;
	}

	public void setSolicitudDAO(SolicitudDAO solicitudDAO) {
		this.solicitudDAO = solicitudDAO;
	}

	//Metodo para obtener una lista de solicitudes del sistema
	@Override
	public List<Solicitud> obtener() throws MyException {
		return solicitudDAO.get();
	}

	//Metodo para guardar una nueva solicitud
	@Override
	public void guardar(Long id, Date fecha, String contenido) throws MyException {

		Solicitud solicitud = null;

		// Validación para que el campo id no este vacio
		if (id == null) {
			throw new MyException("El id de la solicitud no puede ser vacia");
		}

		// Validacion para el campo fecha
		if (fecha == null) {
			throw new MyException("La fecha de la solicitud no puede ser vacia");
		}

		// Validación para que el campo nombre no este vacio
		if (contenido == null || contenido.isEmpty()) {
			throw new MyException("El nombre de la solicitud no puede ser vacia");
		}

		solicitud = new Solicitud();
		solicitud.setId(id);
		solicitud.setFecha(fecha);
		solicitud.setContenido(contenido);

		solicitudDAO.insert(solicitud);

	}

	//Metodo para actualizar una solicitud
	@Override
	public void actualizar(Long id, Date fecha, String contenido) throws MyException {

		Solicitud solicitud = null;

		// Validación para que el campo id no este vacio
		if (id == null) {
			throw new MyException("El id de la solicitud no puede ser vacia");
		}

		// Validacion para el campo fecha
		if (fecha == null) {
			throw new MyException("La fecha de la solicitud no puede ser vacia");
		}

		// Validación para que el campo nombre no este vacio
		if (contenido == null || contenido.isEmpty()) {
			throw new MyException("El nombre de la solicitud no puede ser vacia");
		}

		// retiro id proque es la clave primaria
		// dependencia.setId(id);
		solicitud.setFecha(fecha);
		solicitud.setContenido(contenido);

		solicitudDAO.update(solicitud);
	}

	// Metodo para eliminar una solicitud
	@Override
	public void eliminar(Long id) throws MyException {

		Solicitud solicitud = null;

		// Validación para que el campo id no este vacio
		if (id == null) {
			throw new MyException("El id de la solicitud no puede ser vacia");
		}

		solicitud = solicitudDAO.get(id);

		if (solicitud == null) {
			throw new MyException("La solicitud a eliminar no existe en el sistema");
		}
		solicitudDAO.delete(solicitud);
	}

}
