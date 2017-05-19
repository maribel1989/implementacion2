package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Dependencia;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.MyException;

/**
	 * Interface que define los m�todos permitidos para las solicitudes en el 
	 * sistema
	 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
	 * @since Java 1.7
	 * @version 1.0
	 */
public interface SolicitudDAO {
	
	/**
	 * Obtiene la lista de las solicitudes de usuario que existen en el sistema 
	 * ordenadas 
	 * @return Lista de solicitudes 
	 * @throws MyException ocurre cuando hay un problema con la conexi�n a la BD
	 */
	public List<Solicitud> get() throws MyException;
	
	/**
	 * Obtiene la informaci�n de una solicitud dado su id
	 * @param id de la solicitud
	 * @return objeto Solicitud con la informaci�n almacenada
	 * @throws MyException ocurre cuando hay un error consultando la informaci�n
	 */
	public Solicitud get(Long id) throws MyException;
	
	/**
	 * Almacena los datos de una solicitud en la base de datos
	 * @param solicitud objeto {@link Solicitud} con la informaci�n a almacenar
	 * @throws MyException cuando hay un error almacenando la informaci�n
	 */
	public void insert(Solicitud solicitud) throws MyException;

	/**
	 * Actualiza los datos de una solicitud en la base de datos
	 * @param solicitud objeto {@link Solicitud} con la informaci�n a almacenar
	 * @throws MyException cuando hay un error actualizando la informaci�n
	 */
	public void update(Solicitud solicitud) throws MyException;
	
	/**
	 * Elimina los datos de una solicitud en la base de datos
	 * @param solicitud objeto {@link Solicitud} con la informaci�n a almacenar
	 * @throws MyException cuando hay un error elimiando la informaci�n
	 */
	public void delete(Solicitud solicitud) throws MyException;
}
