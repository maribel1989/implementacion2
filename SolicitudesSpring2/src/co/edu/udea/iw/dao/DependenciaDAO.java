package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.exception.MyException;
import co.edu.udea.iw.dto.Dependencia;

/**
 * Interface que define los m�todos permitidos para las dependencias en el 
 * sistema
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */

public interface DependenciaDAO {
	
	/**
	 * Obtiene la lista de dependencias que existen en el sistema 
	 * ordenadas alfabeticamente por el nombre
	 * @return Lista de dependencias ordenada
	 * @throws MyException ocurre cuando hay un problema con la conexi�n a la BD
	 */
	public List<Dependencia> get() throws MyException;
	
	/**
	 * Obtiene la informaci�n de una dependencia dado su id
	 * @param id de la dependencia
	 * @return objeto Dependencia con la informaci�n almacenada
	 * @throws MyException ocurre cuando hay un error consultando la informaci�n
	 */
	public Dependencia get(Long id) throws MyException;
	
	/**
	 * Almacena los datos de una dependencia en la base de datos
	 * @param dependencia objeto {@link Dependencia} con la informaci�n a almacenar
	 * @throws MyException cuando hay un error almacenando la informaci�n
	 */
	public void insert(Dependencia dependencia) throws MyException;
	
	/**
	 * Modifca los datos de una dependencia en la base de datos
	 * @param dependencia objeto {@link Dependencia} con la informaci�n a modfiicar
	 * @throws MyException cuando hay un error modificando la informaci�n
	 */
	public void update(Dependencia dependencia) throws MyException;
	
	/**
	 * Elimina los datos de una dependencia en la base de datos
	 * @param dependencia objeto {@link Dependencia} con la informaci�n a eliminar
	 * @throws MyException cuando hay un error eliminando la informaci�n
	 */
	
	public void delete(Dependencia dependencia) throws MyException;
}
