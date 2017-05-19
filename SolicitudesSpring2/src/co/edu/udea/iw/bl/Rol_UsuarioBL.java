package co.edu.udea.iw.bl;

import java.util.List;

import co.edu.udea.iw.dto.Rol_Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * Contiene los metodos de la logica de negocio para le entidad Rol_Usuario
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */

public interface Rol_UsuarioBL {
	/**
	 * Entrega la lista de Rol_Usuario
	 * @return Lista de Rol de Usuario
	 * @throws MyExcepntion cuando hay errores obteniendo los Roles de Usuario del sistema
	 */
	public List<Rol_Usuario> obtener() throws MyException;
	
	/**
	 * Crea un rol de usuario en el sistema 
	 * @param id identificacion del tipo de rol
	 * @param tipo_Rol nombre del rol a guardar
	 * @throws MyExcepntion cuando hay errores guardando la dependencia del sistema
	 */
	public void guardar(Long id, String tipo_Rol) throws MyException;
	
	/**
	 * Actualiza un rol de usuario en el sistema 
	 * @param id identificacion del tipo de rol
	 * @param tipo_Rol nombre del rol a guardar
	 * @throws MyExcepntion cuando hay errores guardando la actualizando del sistema
	 */
	public void actualizar(Long id, String tipo_Rol) throws MyException;
	
	/**
	 * Elimina un rol de usuario en el sistema 
	 * @param id identificacion del tipo de rol
	 * @throws MyExcepntion cuando hay errores elimiando el rol de usuario del sistema
	 */
	public void eliminar(Long id) throws MyException;
}
