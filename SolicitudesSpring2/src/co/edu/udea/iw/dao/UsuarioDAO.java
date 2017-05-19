package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
	 * Interface que define los m�todos permitidos para los Usuarios en el 
	 * sistema
	 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
	 * @since Java 1.7
	 * @version 1.0
	 */
public interface UsuarioDAO {
	
	/**
	 * Obtiene la lista de usuarios que existen en el sistema 
	 * ordenadas alfabeticamente por el nombre
	 * @return Lista de usuarios ordenada
	 * @throws MyException ocurre cuando hay un problema con la conexi�n a la BD
	 */
	public List<Usuario> get() throws MyException;
	
	/**
	 * Obtiene la informaci�n de un usuario dado su id
	 * @param id de la usuario
	 * @return objeto Usuario con la informaci�n almacenada
	 * @throws MyException ocurre cuando hay un error consultando la informaci�n
	 */
	public Usuario get(Long id) throws MyException;
	
	/**
	 * Almacena los datos de un Usuario en la base de datos
	 * @param usuario objeto {@link Usuario} con la informaci�n a almacenar
	 * @throws MyException cuando hay un error almacenando la informaci�n
	 */
	public void insert(Usuario usuario) throws MyException;
	
	/**
	 * Modifca los datos de un Usuario en la base de datos
	 * @param usuario objeto {@link Usuario} con la informaci�n a modfiicar
	 * @throws MyException cuando hay un error modificando la informaci�n
	 */
	public void update(Usuario usuario) throws MyException;
	
	/**
	 * Elimina los datos de un usuario en la base de datos
	 * @param usuario objeto {@link Usuario} con la informaci�n a eliminar
	 * @throws MyException cuando hay un error eliminando la informaci�n
	 */
	public void delete(Usuario usuario) throws MyException;
}
