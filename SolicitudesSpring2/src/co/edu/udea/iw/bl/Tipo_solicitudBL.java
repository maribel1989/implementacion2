package co.edu.udea.iw.bl;

import java.util.List;

import co.edu.udea.iw.dto.Tipo_solicitud;
import co.edu.udea.iw.exception.MyException;

/**
 * Contiene los metodos de la logica de negocio para le entidad Dependencia
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */

public interface Tipo_solicitudBL {
	/**
	 * Entrega la lista de Tipo de solicitudes
	 * @return Lista de Tipo de solicitudes
	 * @throws MyExcepntion cuando hay errores obteniendo los tipo de solicitud del sistema
	 */
	public List<Tipo_solicitud> obtener() throws MyException;
	
	/**
	 * Crea un tipo de solicitud en el sistema 
	 * @param id identificacion del tipo de solicitud
	 * @param nombre nombre del tipo de solicitud
	 * @throws MyExcepntion cuando hay errores guardando el tipo de solicitud en el sistema
	 */
	public void guardar(Long id, String nombre) throws MyException;;
	
	/**
	 * Actualiza un tipo de solicitud en el sistema 
	 * @param id identificacion del tipo de solicitud
	 * @param nombre nombre del tipo de solicitud
	 * @throws MyExcepntion cuando hay errores actualizando el tipo de solicitud en el sistema
	 */
	public void actualizar(Long id, String nombre) throws MyException;
	
	/**
	 * Elimina un tipo de solicitud en el sistema 
	 * @param id identificacion del tipo de solicitud
	 * @throws MyExcepntion cuando hay errores elimiando el tipo de solicitud en el sistema
	 */
	public void eliminar(Long id) throws MyException;
}
