package co.edu.udea.iw.bl.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.bl.RespuestaBL;
import co.edu.udea.iw.dao.RespuestaDAO;
import co.edu.udea.iw.dto.Respuesta;
import co.edu.udea.iw.exception.MyException;

@Transactional

public class RespuestaBLImpl implements RespuestaBL {

	private RespuestaDAO respuestaDAO;
	
	public RespuestaDAO getRespuestaDAO() {
		return respuestaDAO;
	}

	public void setRespuestaDAO(RespuestaDAO respuestaDAO) {
		this.respuestaDAO = respuestaDAO;
	}
	
	//Metodo que obtienen una lista de respuestas del sistema
	@Override
	public List<Respuesta> obtener() throws MyException {
		return respuestaDAO.get();
	}

	//Metodo para guardar una respuesta
	@Override
	public void guardar(Long id, Date fecha, String contenido) throws MyException {
		
		Respuesta respuesta = null;
		
		//Validación para que el campo id no este vacio
		if(id==null){
			throw new MyException("El id de la respuesta no puede ser vacia");
		}
		
		//Validacion para el campo fecha
		if(fecha==null){
			throw new MyException("La fecha de la respuesta no puede ser vacia");
		}
		
		//Validación para que el campo nombre no este vacio
		if(contenido==null || contenido.isEmpty()){
			throw new MyException("El nombre de la respuesta no puede ser vacia");
		}
		
		respuesta= new Respuesta();
		respuesta.setId(id);
		respuesta.setFecha(fecha);
		respuesta.setContenido(contenido);
		
		respuestaDAO.insert(respuesta);
		
	}
	
	//Metodo para actualizar una respuesta
	@Override
	public void actualizar(Long id, String contenido) throws MyException{
	
		Respuesta respuesta = null;
		
		//Validación para que el campo id no este vacio
		if(id==null){
			throw new MyException("El id de la respuesta no puede ser vacia");
		}
		
		//Validación para que el campo contenido no este vacio
		if(contenido==null || contenido.isEmpty()){
			throw new MyException("El contenido de la respuesta no puede ser vacia");
		}	
		
		respuesta= respuestaDAO.get(id);
		
		if(respuesta ==null){
			throw new MyException("La respuesta a modificar no existe en el sistema");
		}
		
		//retiro id proque es la clave primaria
		//respuesta.setId(id);
		respuesta.setContenido(contenido);
		
		respuestaDAO.update(respuesta);
	}
	
	//Metodo para eliminar una respuesta
	@Override
	public void eliminar(Long id ) throws MyException {
		
		Respuesta respuesta = null;
		
		//Validación para que el campo id no este vacio
		if(id==null){
			throw new MyException("El id de la respuesta no puede ser vacia");
		}	
		
		respuesta= respuestaDAO.get(id);
		
		if(respuesta ==null){
			throw new MyException("La respuesta a eliminar no existe en el sistema");
		}
		respuestaDAO.delete(respuesta);
	}
}
