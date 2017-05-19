package co.edu.udea.iw.bl.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.bl.DependenciaBL;
import co.edu.udea.iw.dao.DependenciaDAO;
import co.edu.udea.iw.dto.Dependencia;
import co.edu.udea.iw.exception.MyException;

@Transactional

public class DependenciaBLImpl implements DependenciaBL {
	
	private DependenciaDAO dependenciaDAO;

	public DependenciaDAO getDependenciaDAO() {
		return dependenciaDAO;
	}

	public void setDependenciaDAO(DependenciaDAO dependenciaDAO) {
		this.dependenciaDAO = dependenciaDAO;
	}

	//Metodo que obtiene una lista de Dependencias
	@Override
	public List<Dependencia> obtener() throws MyException {
		return dependenciaDAO.get();
	}

	//Metodo para guardar una dependencia
	@Override
	public void guardar(Long id, String nombre) throws MyException {
		
		Dependencia dependencia = null;
		
		//Validación para que el campo id no este vacio
		if(id==null){
			throw new MyException("El id de la dependencia no puede ser vacia");
		}
		
		//Validación para que el campo nombre no este vacio
		if(nombre==null || nombre.isEmpty()){
			throw new MyException("El nombre de la dependencia no puede ser vacia");
		}	
		
		dependencia= new Dependencia();
		dependencia.setId(id);
		dependencia.setNombre(nombre);
		
		dependenciaDAO.insert(dependencia);
	}
	
	//Metodo para actualizar una dependencia
	@Override
	public void actualizar(Long id, String nombre) throws MyException {
		
		Dependencia dependencia = null;
		
		//Validación para que el campo id no este vacio
		if(id==null){
			throw new MyException("El id de la dependencia no puede ser vacia");
		}
		
		//Validación para que el campo nombre no este vacio
		if(nombre==null || nombre.isEmpty()){
			throw new MyException("El nombre de la dependencia no puede ser vacia");
		}	
		
		dependencia= dependenciaDAO.get(id);
		
		if(dependencia ==null){
			throw new MyException("La dependencia a modificar no existe en el sistema");
		}
		
		//retiro id proque es la clave primaria
		//dependencia.setId(id);
		dependencia.setNombre(nombre);
		
		dependenciaDAO.update(dependencia);
	}

	//Metodo para eliminar una dependencia
	@Override
	public void eliminar(Long id ) throws MyException {
		
		Dependencia dependencia = null;
		
		//Validación para que el campo id no este vacio
		if(id==null){
			throw new MyException("El id de la dependencia no puede ser vacia");
		}	
		
		dependencia= dependenciaDAO.get(id);
		
		if(dependencia ==null){
			throw new MyException("La dependencia a eliminar no existe en el sistema");
		}
		dependenciaDAO.delete(dependencia);
	}
}
