package co.edu.udea.iw.bl.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.bl.Tipo_solicitudBL;
import co.edu.udea.iw.dao.Tipo_solicitudDAO;
import co.edu.udea.iw.dto.Tipo_solicitud;
import co.edu.udea.iw.exception.MyException;

@Transactional

public class Tipo_solicitudBLImpl implements Tipo_solicitudBL {
	private Tipo_solicitudDAO tipo_solicitudDAO;

	public Tipo_solicitudDAO getTipo_solicitudDAO() {
		return tipo_solicitudDAO;
	}

	public void setTipo_solicitudDAO(Tipo_solicitudDAO tipo_solicitudDAO) {
		this.tipo_solicitudDAO = tipo_solicitudDAO;
	}

	//Metodo para obtener una lista de tipo de solicitudes
	@Override
	public List<Tipo_solicitud> obtener() throws MyException {
		return tipo_solicitudDAO.get();
	}

	//Metodo para guarddar un nuevo tipo de solicitud
	@Override
	public void guardar(Long id, String nombre) throws MyException {

		Tipo_solicitud tipo_solicitud = null;

		// Validación para que el campo id no este vacio
		if (id == null) {
			throw new MyException("El id del tipo de solicitud no puede ser vacia");
		}

		// Validación para que el campo nombre no este vacio
		if (nombre == null || nombre.isEmpty()) {
			throw new MyException("El nombre del tipo de solicitud no puede ser vacia");
		}

		tipo_solicitud = new Tipo_solicitud();
		tipo_solicitud.setId(id);
		tipo_solicitud.setNombre(nombre);

		tipo_solicitudDAO.insert(tipo_solicitud);
	}

	//Metodo para actualizar un tipo de solicitud
	@Override
	public void actualizar(Long id, String nombre) throws MyException {

		Tipo_solicitud tipo_solicitud = null;

		// Validación para que el campo id no este vacio
		if (id == null) {
			throw new MyException("El id del tipo de solicitud no puede ser vacia");
		}

		// Validación para que el campo nombre no este vacio
		if (nombre == null || nombre.isEmpty()) {
			throw new MyException("El nombre del tipo de solicitud no puede ser vacia");
		}

		tipo_solicitud = tipo_solicitudDAO.get(id);

		if (tipo_solicitud == null) {
			throw new MyException("El tipo de solicitud a modificar no existe en el sistema");
		}

		// retiro id proque es la clave primaria
		// tipo_solicitud.setId(id);
		tipo_solicitud.setNombre(nombre);

		tipo_solicitudDAO.update(tipo_solicitud);
	}

	// Metodo para eliminar un tipo de solicitud
	@Override
	public void eliminar(Long id) throws MyException {

		Tipo_solicitud tipo_solicitud = null;

		// Validación para que el campo id no este vacio
		if (id == null) {
			throw new MyException("El id del tipo de solicitud no puede ser vacia");
		}

		tipo_solicitud = tipo_solicitudDAO.get(id);

		if (tipo_solicitud == null) {
			throw new MyException("El tipo de solicitud a eliminar no existe en el sistema");
		}
		tipo_solicitudDAO.delete(tipo_solicitud);
	}

}
