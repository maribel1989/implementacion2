package co.edu.udea.iw.bl;

import java.util.List;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * Contiene los metodos de la logica de negocio para le entidad Usuario
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
public interface UsuarioBL {
	/**
	 * Entrega la lista de Usuarios
	 * @return Lista de Usuarios
	 * @throws MyExcepntion cuando hay errores obteniendo los Usuarios del sistema
	 */
	public List<Usuario> obtener() throws MyException;
	
	/**
	 * Crea una Usuarios en el sistema 
	 * @param id identificacion del Usuario
	 * @param nombre nombre del Usuario
	 * @param apellido apellido del usuario
	 * @param telefono telefono del usuario
	 * @param email email del usuario
	 * @throws MyExcepntion cuando hay errores guardando el Usuario en el sistema
	 */
	public void guardar(Long id, String nombre, String apellido, String telefono, String email) throws MyException;
	
	/**
	 * Actualiza un Usuario en el sistema 
	 * @param id identificacion del Usuario
	 * @param nombre nombre del Usuario
	 * @param apellido apellido del usuario
	 * @param telefono telefono del usuario
	 * @param email email del usuario
	 * @throws MyException cuando hay errores actualizando el Usuario en el sistema
	 */
	public void actualizar(Long id, String nombre, String apellido, String telefono, String email) throws MyException;
	
	/**
	 * Elimina un Usuario en el sistema 
	 * @param id identificacion del Usuario
	 * @throws MyException cuando hay errores elimiando el Usuario en el sistema
	 */
	public void eliminar(Long id) throws MyException;
}
