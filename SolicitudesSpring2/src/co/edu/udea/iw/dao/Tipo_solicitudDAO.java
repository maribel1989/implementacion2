package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Tipo_solicitud;
import co.edu.udea.iw.exception.MyException;

/**
	 * Interface que define los m�todos permitidos para los tipos de solicitudes en el 
	 * sistema
	 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
	 * @since Java 1.7
	 * @version 1.0
	 */
public interface Tipo_solicitudDAO {
	
	/**
	 * Obtiene la lista de los tipos de solicitudes que existen en el sistema 
	 * ordenadas 
	 * @return Lista de tipo solicitudes 
	 * @throws MyException ocurre cuando hay un problema con la conexi�n a la BD
	 */
	public List<Tipo_solicitud> get() throws MyException;
	
	/**
	 * Obtiene la informaci�n de un Tipo_solicitud dado su id
	 * @param id del tipo_solicitud
	 * @return objeto Tipo_solicitud con la informaci�n almacenada
	 * @throws MyException ocurre cuando hay un error consultando la informaci�n
	 */
		public Tipo_solicitud get(Long id) throws MyException;
	
	/**
	 * Almacena los datos de un Tipo_solicitud en la base de datos
	 * @param tipo_solicitud objeto {@link Tipo_solicitud} con la informaci�n a almacenar
	 * @throws MyException cuando hay un error almacenando la informaci�n
	 */
	public void insert(Tipo_solicitud tipo_solicitud) throws MyException;
	
	/**
	 * Modifca los datos de un Tipo_solicitud en la base de datos
	 * @param tipo_solicitud objeto {@link Tipo_solicitud} con la informaci�n a modificar
	 * @throws MyException cuando hay un error modificando la informaci�n
	 */
	public void update(Tipo_solicitud tipo_solicitud) throws MyException;
	
	/**
	 * Elimina los datos de un Tipo_solicitud en la base de datos
	 * @param tipo_solicitud objeto {@link Tipo_solicitud} con la informaci�n a eliminar
	 * @throws MyException cuando hay un error eliminando la informaci�n
	 */	
	public void delete(Tipo_solicitud tipo_solicitud) throws MyException;
}
