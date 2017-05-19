package co.edu.udea.iw.bl;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.dto.Respuesta;
import co.edu.udea.iw.exception.MyException;

/**
 * Contiene los metodos de la logica de negocio para le entidad Respuesta
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */

public interface RespuestaBL {
	/**
	 * Entrega la lista de Respuestas
	 * @param  
	 * @return Lista de Respuestas
	 * @throws MyExcepntion cuando hay errores obteniendo las respuestas del sistema
	 */
	public List<Respuesta> obtener() throws MyException;
	
	/**
	 * Crea una respuesta en el sistema 
	 * @param id identificacion de la respuesta
	 * @param usuario_Id identificacion del usuario quien realiza la respuesta
	 * @param fecha  fecha en la cual se guarda la respuesta
	 * @param contenido Cuerpo del contenido de la respuesta
	 * @throws MyExcepntion cuando hay errores guardando la respuesta del sistema
	 */
	public void guardar(Long id, Date fecha, String contenido) throws MyException;
	
	/**
	 * Actualiza una respuesta en el sistema 
	 * @param id identificacion de la respuesta
	 * @param contenido nombre de la respuesta
	 * @throws MyExcepntion cuando hay errores actualizando la respuesta del sistema
	 */
	public void actualizar(Long id, String contenido) throws MyException;
	
	/**
	 * Elimina una respuesta en el sistema 
	 * @param id identificacion de la respuesta
	 * @throws MyExcepntion cuando hay errores elimianndo la dependencia del sistema
	 */
	public void eliminar(Long id) throws MyException;
}
