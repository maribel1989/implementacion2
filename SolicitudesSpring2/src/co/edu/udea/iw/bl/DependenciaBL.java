package co.edu.udea.iw.bl;

import java.util.List;

import co.edu.udea.iw.dto.Dependencia;
import co.edu.udea.iw.exception.MyException;

/**
 * Contiene los metodos de la logica de negocio para le entidad Dependencia
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
public interface DependenciaBL {

	/**
	 * Entrega la lista de Dependencias
	 * @return Lista de Dependencias
	 * @throws MyExcepntion cuando hay errores obteniendo los clientes del sistema
	 */
	public List<Dependencia> obtener() throws MyException;
	
	/**
	 * Crea una dependencia en el sistema 
	 * @param id identificacion de la dependencia
	 * @param nombre nombre de la dependencia
	 * @throws MyExcepntion cuando hay errores guardando la dependencia del sistema
	 */
	public void guardar(Long id, String nombre) throws MyException;
	
	/**
	 * Actualiza una dependencia en el sistema 
	 * @param id identificacion de la dependencia
	 * @param nombre nombre de la dependencia
	 * @throws MyExcepntion cuando hay errores actualizando la dependencia del sistema
	 */
	public void actualizar(Long id, String nombre) throws MyException;
	
	/**
	 * Elimina una dependencia en el sistema 
	 * @param id identificacion de la dependencia
	 * @throws MyExcepntion cuando hay errores eliminando la dependencia del sistema
	 */
	public void eliminar(Long id) throws MyException;
}
