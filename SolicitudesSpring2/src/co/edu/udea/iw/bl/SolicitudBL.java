package co.edu.udea.iw.bl;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.MyException;

/**
 * Contiene los metodos de la logica de negocio para le entidad Solicitud
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
public interface SolicitudBL {
	/**
	 * Entrega la lista de Solicitudes
	 * @return Lista de Solicitudes
	 * @throws MyExcepntion cuando hay errores obteniendo las solicitudes del sistema
	 */
	public List<Solicitud> obtener() throws MyException;
	
	/**
	 * Crea una solicitud en el sistema 
	 * @param id identificacion de la solicitud
	 * @param fecha  fecha en la cual se guarda la solicitud
	 * @param contenido Cuerpo del contenido de la solicitud
	 * @throws MyExcepntion cuando hay errores guardando la solicitud del sistema
	 */
	public void guardar(Long id, Date fecha, String contenido) throws MyException;
	
	/**
	 * Actualiza una solicitud en el sistema 
	 * @param id identificacion de la solicitud
	 * @param fecha  fecha en la cual se actualiza la solicitud
	 * @param contenido Cuerpo del contenido de la solicitud
	 * @throws MyExcepntion cuando hay errores actualizando la solicitud del sistema
	 */
	public void actualizar(Long id, Date fecha, String contenido) throws MyException;
	
	/**
	 * Elimina una solicitud en el sistema 
	 * @param id identificacion de la solicitud
	 * @throws MyExcepntion cuando hay errores eliminado la solicitud del sistema
	 */
	public void eliminar(Long id) throws MyException;
}
