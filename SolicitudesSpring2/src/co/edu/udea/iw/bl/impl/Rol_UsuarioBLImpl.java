package co.edu.udea.iw.bl.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.bl.Rol_UsuarioBL;
import co.edu.udea.iw.dao.Rol_UsuarioDAO;
import co.edu.udea.iw.dto.Rol_Usuario;
import co.edu.udea.iw.exception.MyException;

@Transactional

public class Rol_UsuarioBLImpl implements Rol_UsuarioBL {

	private Rol_UsuarioDAO rol_UsuarioDAO;
	
	public Rol_UsuarioDAO getRol_UsuarioDAO() {
		return rol_UsuarioDAO;
	}	
	
	public void setRol_UsuarioDAO(Rol_UsuarioDAO rol_UsuarioDAO) {
		this.rol_UsuarioDAO = rol_UsuarioDAO;
	}

	//Metodo para obtaener una lista de rol de usuarios del sistema
	@Override
	public List<Rol_Usuario> obtener() throws MyException {
		// TODO Auto-generated method stub
		return null;
	}

	//Metodo para guardar un Nuevo Rol de Usuario
	@Override
	public void guardar(Long id, String tipo_Rol) throws MyException {
		
		Rol_UsuarioBL rol_Usuario = null;
		
		//Validación para que el campo id no este vacio
		if(id==null){
			throw new MyException("El id del rol usuario no puede ser vacia");
		}
				
		//Validación para que el campo tipo_Rol no este vacio
		if(tipo_Rol==null || tipo_Rol.isEmpty()){
			throw new MyException("El nombre del rol no puede ser vacio");
		}
	}
	
	//Metodo para actualizar un rol de usuario
	@Override
	public void actualizar(Long id, String tipo_Rol) throws MyException {
		
		Rol_Usuario rol_Usuario = null;
		
		//Validación para que el campo id no este vacio
		if(id==null){
			throw new MyException("El id del rol no puede ser vacia");
		}
		
		//Validación para que el campo tipo rol no este vacio
		if(tipo_Rol==null || tipo_Rol.isEmpty()){
			throw new MyException("El nombre del rol no puede ser vacia");
		}	
		
		rol_Usuario= rol_UsuarioDAO.get(id);
		
		if(rol_Usuario ==null){
			throw new MyException("El rol a modificar no existe en el sistema");
		}
		
		//retiro id proque es la clave primaria
		//rol_Usuario.setId(id);
		rol_Usuario.setTipo_Rol(tipo_Rol);
		
		rol_UsuarioDAO.update(rol_Usuario);
	}

	//Metodo para eliminar un Tipo de Rol
	@Override
	public void eliminar(Long id ) throws MyException {
		
		Rol_Usuario rol_Usuario = null;
		
		//Validación para que el campo id no este vacio
		if(id==null){
			throw new MyException("El id de el rol_Usuario no puede ser vacia");
		}	
		
		rol_Usuario= rol_UsuarioDAO.get(id);
		
		if(rol_Usuario ==null){
			throw new MyException("El rol de usuario a eliminar no existe en el sistema");
		}
		rol_UsuarioDAO.delete(rol_Usuario);
	}

}
