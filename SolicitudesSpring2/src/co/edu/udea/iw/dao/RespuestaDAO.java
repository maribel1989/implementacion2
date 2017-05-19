package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Respuesta;
import co.edu.udea.iw.exception.MyException;

	 /**
	 * Interface que define los m�todos permitidos para las respuestas en el 
	 * sistema
	 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
	 * @since Java 1.7
	 * @version 1.0
	 */
public interface RespuestaDAO {
	/**
	 * Obtiene la lista de Respuestas que existen en el sistema 
	 * @return Lista de Respuestas 
	 * @throws MyException ocurre cuando hay un problema con la conexi�n a la BD
	 */
	public List<Respuesta> get() throws MyException;
	
	/**
	 * Obtiene la informaci�n de una Respuesta dado su id
	 * @param id de la respuesta
	 * @return objeto Respuesta con la informaci�n almacenada
	 * @throws MyException ocurre cuando hay un error consultando la informaci�n
	 */
	public Respuesta get(Long id) throws MyException;
	
	/**
	 * Almacena los datos de una respuesta en la base de datos
	 * @param respuesta objeto {@link Respuesta} con la informaci�n a almacenar
	 * @throws MyException cuando hay un error almacenando la informaci�n
	 */
	public void insert(Respuesta respuesta) throws MyException;

	/**
	 * Actualiza los datos de una respuesta en la base de datos
	 * @param respuesta objeto {@link Respuesta} con la informaci�n a almacenar
	 * @throws MyException cuando hay un error actualizando la informaci�n
	 */
	public void update(Respuesta respuesta) throws MyException;
	
	/**
	 * Elimina los datos de una respuesta en la base de datos
	 * @param respuesta objeto {@link Respuesta} con la informaci�n a almacenar
	 * @throws MyException cuando hay un error elimiando la informaci�n
	 */
	public void delete(Respuesta respuesta) throws MyException;
}
